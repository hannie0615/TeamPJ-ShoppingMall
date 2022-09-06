package com.example.TeamProject01.repository;

import com.example.TeamProject01.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
