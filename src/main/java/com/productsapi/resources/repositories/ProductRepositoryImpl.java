package com.productsapi.resources.repositories;

import com.productsapi.domain.entities.Product;
import com.productsapi.domain.exceptions.ProductNotFound;
import com.productsapi.domain.repositories.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepositoryImpl implements ProductRepository {


    private final EntityManager entityManager;

    @Inject
    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(Long id) throws ProductNotFound {
        Product product = entityManager.find(Product.class, id);
        if(product == null){
            throw new ProductNotFound("Product not found");
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        Query query = entityManager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteProductById(Long id) {
        int isSuccessful = entityManager.createQuery("delete from Product p where p.id=:id")
                .setParameter("id", id)
                .executeUpdate();
        if (isSuccessful == 0) {
            throw new OptimisticLockException("product modified concurently");
        }
    }

    @Override
    @Transactional
    public Product update(Product product) {
        int resultUpdate = entityManager.createQuery("update Product p set p.description = :p1, p.price = :p2, p.name = :p3  where p.id=:id ")
                .setParameter("p1", product.getDescription())
                .setParameter("p2", product.getPrice())
                .setParameter("p3", product.getName())
                .setParameter("id", product.getId())
                .executeUpdate();
        if (resultUpdate == 0) {
            throw new OptimisticLockException("product not modified");
        } else {
        return product;
    }}
}
