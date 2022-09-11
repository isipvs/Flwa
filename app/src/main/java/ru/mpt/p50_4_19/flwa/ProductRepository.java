package ru.mpt.p50_4_19.flwa;

import java.util.List;
import java.util.Optional;

import Entity.Product;

/** */
public interface ProductRepository {
    /** */
    List<Product> findAll();
    /** */
    Optional<Product> findById(int id);
}
