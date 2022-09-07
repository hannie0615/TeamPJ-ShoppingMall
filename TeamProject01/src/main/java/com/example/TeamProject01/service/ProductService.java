package com.example.TeamProject01.service;

import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.Domain.ProductImage;
import com.example.TeamProject01.repository.ProductRepository;
import com.example.TeamProject01.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductService {

    private ProductRepositoryInterface repository;

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product p){

        p.setPrd_name(p.getPrd_name());
        p.setPrd_price(p.getPrd_price());
        p.setPrd_cmp(p.getPrd_cmp());
        p.setPrd_type(p.getPrd_type());
        p.setPrd_ment(p.getPrd_ment());
        p.setPrd_sales(p.getPrd_sales());

        return productRepository.save(p);
    }

    public void uploadImage(ProductImage pi){
        repository.saveProductImage(pi);
    }

    @Autowired
    public ProductService(ProductRepositoryInterface repository){
        this.repository = repository;
    }


}
