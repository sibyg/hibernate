package org.sibyg.hibernate.tutorial.dao;

public interface BasicDao<T> {
    void create(T t);
    void delete(Long id);
    void get(Long id);
    void update(T t);
}
