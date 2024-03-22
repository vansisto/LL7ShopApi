package com.vansisto.ll7shopapi.service;

public interface BaseCRUDService<T> {
    void create(T t);
    T getById(Long id);
    void update(T t);
    void deleteById(Long id);
}
