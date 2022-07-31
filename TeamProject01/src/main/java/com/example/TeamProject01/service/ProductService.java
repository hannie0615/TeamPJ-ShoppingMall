package com.example.TeamProject01.service;

import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductService {

    private ProductRepositoryInterface repository;
    @Autowired
    public ProductService(ProductRepositoryInterface repository){
        this.repository = repository;
    }

    public void add(Product p){
        repository.saveProduct(p);
    }

}
