//package com.productsapi.domain.services;
//
//import com.productsapi.application.payloads.ProductRequest;
//import com.productsapi.application.payloads.ProductResponse;
//import com.productsapi.domain.entities.Product;
//import com.productsapi.domain.exceptions.ProductNotFound;
//import com.productsapi.domain.repositories.ProductRepository;
//import io.quarkus.test.junit.QuarkusTest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.wildfly.common.Assert;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@QuarkusTest
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @Mock
//    ProductRepository repository;
//
//    private ProductService service;
//
//    @BeforeEach
//    void init() {
//        this.service = new ProductServiceImpl(repository);
//    }
//
//    @Test
//    void testFindById() throws ProductNotFound {
//        Long ID = 1L;
//        Product product = mockProduct();
//        when(this.repository.findById(ID)).thenReturn(product);
//
//        ProductResponse response = this.service.findById(ID);
//
//        Assert.assertNotNull(response);
//        Assert.assertTrue(product.getName().equals(response.getName()));
//    }
//
//    @Test
//    void testFindAll() {
//        when(this.repository.findAll()).thenReturn(Arrays.asList(mockProduct(), mockProduct()));
//
//        List<ProductResponse> responses = this.service.findAll();
//        Assert.assertNotNull(responses);
//        Assert.assertTrue(2 == responses.size());
//    }
//
//    @Test
//    void testCreate() {
//        Product product = mockProduct();
//
//        this.service.create(new ProductRequest(product.getName(), product.getDescription(), product.getPrice()));
//
//        verify(this.repository, times(1)).create(any());
//    }
//
//    private Product mockProduct() {
//        return new Product("test product", "test description", new BigDecimal(15));
//    }
//}
