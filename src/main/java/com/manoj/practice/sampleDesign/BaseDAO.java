package com.manoj.practice.sampleDesign;

public interface BaseDAO<E> {

    public void save(E e);

    public void delete(E e);
}
