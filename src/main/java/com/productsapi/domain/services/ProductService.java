package com.productsapi.domain.services;

import com.productsapi.application.payloads.ProductRequest;
import com.productsapi.application.payloads.ProductResponse;
import com.productsapi.domain.entities.Product;
import com.productsapi.domain.exceptions.ProductNotFound;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest product);
    ProductResponse findById(Long id) throws ProductNotFound;
    List<ProductResponse> findAll();
    void deleteProductById(Long id);
    ProductResponse update(Product product) throws ProductNotFound;
}
