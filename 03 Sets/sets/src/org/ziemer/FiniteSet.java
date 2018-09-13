package org.ziemer;

public class FiniteSet<T extends Comparable> implements Set {

    private T[] values;

    public FiniteSet(T... values) {
        this.values = values;
    }

    @Override
    public Boolean member(Comparable member) {
        for (T val : this.values) {
            if (val.equals(member)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set result(Set set) {
        return null;
    }

    public T[] getValues() {
        return values;
    }

    public void setValues(T[] values) {
        this.values = values;
    }
}
