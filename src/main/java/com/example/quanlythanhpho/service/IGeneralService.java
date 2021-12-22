package com.example.quanlythanhpho.service;

import java.util.Optional;

public interface IGeneralService<T> {
    T save(T t);

    void remove(Long id);

    Iterable<T> findAll();

    Optional<T> findById(Long id);
}
