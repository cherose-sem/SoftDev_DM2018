package org.ziemer;

interface Set<T extends Comparable> {
    Boolean member(T member);
    Set<T> result(Set<T> set);
}
