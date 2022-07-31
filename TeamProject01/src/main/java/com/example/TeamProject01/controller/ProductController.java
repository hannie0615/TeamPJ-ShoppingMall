package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductController {

    ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @PostMapping("/addlist")
    public String goAddProduct(){
        return "product/addProduct";
    }

    @PostMapping("/product/new")
    public String create(@Valid ProductForm pf) throws ParseException {

        Product p = new Product();
        p.setPrd_name(pf.getPrd_name());
        p.setPrd_price(pf.getPrd_price());
        p.setPrd_cmp(pf.getPrd_cmp());
        p.setPrd_type(pf.getPrd_type());
        p.setPrd_img(pf.getPrd_img());
        p.setRealfile(pf.getRealfile());
        p.setPrd_ment(pf.getPrd_ment());
        p.setPrd_stock(pf.getPrd_stock());

        // DB에 넣기

        service.add(p);
        return "redirect:/";
    }
}
