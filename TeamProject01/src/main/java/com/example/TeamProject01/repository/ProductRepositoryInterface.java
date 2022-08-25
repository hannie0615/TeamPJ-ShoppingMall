package com.example.TeamProject01.repository;

import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.Domain.ProductImage;

public interface ProductRepositoryInterface {

    Product saveProduct(Product p);
    void saveProductImage(ProductImage productImage);
}
