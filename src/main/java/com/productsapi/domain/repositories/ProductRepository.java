package com.productsapi.domain.repositories;

import com.productsapi.domain.entities.Product;
import com.productsapi.domain.exceptions.ProductNotFound;

import java.util.List;

public interface ProductRepository {

    void create(Product product);
    Product findById(Long id) throws ProductNotFound;
    List<Product> findAll();
    void deleteProductById(Long id);
    Product update(Product product) throws ProductNotFound;

}
