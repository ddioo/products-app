package com.productsapi.domain.services;

import com.productsapi.application.payloads.ProductRequest;
import com.productsapi.application.payloads.ProductResponse;
import com.productsapi.domain.entities.Product;
import com.productsapi.domain.exceptions.ProductNotFound;
import com.productsapi.domain.repositories.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Inject
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductResponse create(ProductRequest pr) {
        Product product = buildProduct(pr);
        repository.create(product);
        return buildProductResponse(product);
    }

    @Override
    public ProductResponse findById(Long id) throws ProductNotFound {
        return buildProductResponse(repository.findById(id));
    }

    @Override
    public List<ProductResponse> findAll() {
        return repository.findAll().stream().map(this::buildProductResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteProductById(Long id) {
        repository.deleteProductById(id);
    }

    @Override
    public ProductResponse update(Product product) throws ProductNotFound {
        return  buildProductResponse(repository.update(product));
    }

    private Product buildProduct(ProductRequest pr){
        return new Product(pr.getName(), pr.getDescription(), pr.getPrice());
    }

    private ProductResponse buildProductResponse(Product product){
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
