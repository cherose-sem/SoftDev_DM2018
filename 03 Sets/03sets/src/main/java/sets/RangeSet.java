package sets;

public class RangeSet<T extends Comparable> implements Set {

    private T min;
    private T max;

    public RangeSet(T min, T max) {
        this.min = min;
        this.max = max;

    }

    @Override
    public Boolean member(java.lang.Comparable member) {
        if (member.compareTo(min) >= 0 && member.compareTo(max) <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public Set result(Set set) {
        return null;
    }

    public Comparable getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }
}
