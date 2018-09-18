package sets;

import java.util.Set;

public interface Sets<T extends Comparable> {
    Set<T> members();
    boolean hasMin();
    boolean hasMax();
    boolean member(T member);
    Sets<T> union(Sets<T> set);
    Sets<T> intersection(Sets<T> set);
    Sets<T> difference(Sets<T> set);
    Sets<T> complement();
    int compareTo(Sets<T> set);
    void printFormatted();
}
