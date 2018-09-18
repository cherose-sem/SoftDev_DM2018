package sets;

import java.util.HashSet;
import java.util.Set;

public class SetsImpl<T extends Comparable> implements Sets {

    private Set<T> members;
    private boolean noMin = false;
    private boolean noMax = false;

    public SetsImpl(Set<T> members) {
        this.members = members;
    }

    public SetsImpl(boolean noMin, boolean noMax, Set<T> members) {
        this.members = members;
        this.noMin = noMin;
        this.noMax = noMax;
    }

    @Override
    public Set<T> members() {
        return this.members;
    }

    @Override
    public boolean hasMin() {
        return !noMin;
    }

    @Override
    public boolean hasMax() {
        return !noMax;
    }

    @Override
    public boolean member(Comparable member) {
        T[] arr = (T[]) members.toArray();
        if (arr[arr.length - 1].compareTo(member) < 0 && noMax) {
            return true;
        }

        if (arr[0].compareTo(member) > 0 && noMin) {
            return true;
        }

        for (T mem : members) {
            if (mem.equals(member)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Sets union(Sets set) {
        boolean noMax = this.noMax || !set.hasMax();
        boolean noMin = this.noMin || !set.hasMin();
        Set<T> members = new HashSet<>();
        for (T m : this.members) {
            members.add(m);
        }

        for (Object m : set.members()) {
            members.add((T) m);
        }

        return new SetsImpl<T>(noMin, noMax, members);
    }

    @Override
    public Sets intersection(Sets set) {
        Set<T> members = new HashSet<>();
        for (T m : this.members) {
            if (set.members().contains(m)) {
                members.add(m);
            }
        }
        return new SetsImpl<>(members);
    }

    @Override
    public Sets difference(Sets set) {
        Set<T> members = new HashSet<>(this.members);
        members.removeAll(set.members());
        return new SetsImpl<>(members);
    }

    @Override
    public Sets complement() {
        return null;
    }

    @Override
    public int compareTo(Sets set) {
        if (properSubSet(set)) {
            return -1;
        }

        if (equals(set)) {
            return 0;
        }

        if (superSet(set)) {
            return 1;
        }

        if (subSet(set)) {
            return -2;
        }

        return 2;
    }

    @Override
    public void printFormatted() {
        System.out.print("{");
        if (this.noMin) System.out.print("..., ");
        members.forEach(element -> {
            System.out.print(element + ", ");
        });
        if (this.noMax) System.out.print("...");
        System.out.print("}");
    }

    private boolean properSubSet(Sets<T> setB) {
        if ((this.noMax && setB.hasMax()) || (this.noMin && setB.hasMin())) {
            return false;
        }

        if (setB.members().containsAll(this.members) && setB.members().size() > this.members.size()) {
            return true;
        }
        return false;
    }

    private boolean equals(Sets<T> setB) {
        if ((setB.hasMax() && !this.hasMax()) || (setB.hasMin() && !this.hasMin())) {
            return false;
        }

        if (setB.members().containsAll(this.members) && setB.members().size() == this.members.size()) {
            return true;
        }
        return false;
    }

    private boolean superSet(Sets<T> setB) {
        if ((this.noMax && !setB.hasMax()) || (this.noMin && !setB.hasMin())) {
            return false;
        }

        if (this.members().containsAll(setB.members()) && this.members().size() > setB.members().size()) {
            return true;
        }
        return false;
    }

    private boolean subSet(Sets<T> setB) {
        if ((this.noMax && setB.hasMax()) || (this.noMin && setB.hasMin())) {
            return false;
        }

        if (setB.members().containsAll(this.members) && setB.members().size() >= this.members.size()) {
            return true;
        }
        return false;
    }
}
