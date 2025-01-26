package com.ambro.space.hibernate.dao;

public interface DAO<T> {
    public T add(T item);
    public T get(String item);
    public T update(T item);
    public T delete(T item);
}
