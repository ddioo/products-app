package com.productsapi.application.controllers;

import com.productsapi.application.payloads.ProductRequest;
import com.productsapi.application.payloads.ProductResponse;
import com.productsapi.domain.entities.Product;
import com.productsapi.domain.exceptions.ProductNotFound;
import com.productsapi.domain.services.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductsController {

    private final ProductService service;

    Logger logger = Logger.getLogger("Controller");

    @Inject
    public ProductsController(ProductService service) {

        this.service = service;
    }

    @GET
    public Response list() {
        return Response.ok(this.service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) throws ProductNotFound {
        return Response.ok(this.service.findById(id)).build();
    }

    @POST
    public Response create(ProductRequest productRequest) throws URISyntaxException {
        return Response.created(new URI("/"+ this.service.create(productRequest).getId())).build() ;
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") Long id) throws ProductNotFound {
        ProductResponse response = this.service.findById(id);
        if (response == null){
            throw new NotFoundException();
        }
        service.deleteProductById(id);
    }

    @PUT
    @Path("/{id}")
    public Response update(Product product) throws ProductNotFound {
        ProductResponse response = this.service.update(product);
        logger.info("INSIDE UPDATE - " + response);
        if (response == null) {
            throw new NotFoundException();
        }
        return Response.ok(response).build();
    }
}