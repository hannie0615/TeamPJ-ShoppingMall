package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.Domain.ProductImage;
import com.example.TeamProject01.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

//    @Value("${spring.servlet.multipart.location}")
//    String imgpath;

    @PostMapping("/newproduct")
    public String createProduct(@Valid ProductForm pf) throws ParseException, IOException {

        Product p = new Product();

        p.setPrd_name(pf.getPrd_name());
        p.setPrd_price(pf.getPrd_price());
        p.setPrd_cmp(pf.getPrd_cmp());
        p.setPrd_type(pf.getPrd_type());
        p.setPrd_ment(pf.getPrd_ment());
        p.setPrd_sales(pf.getPrd_sales());
        List<ProductImage> list = new ArrayList<>();
        // DB에 넣기
        service.add(p);

//        for(MultipartFile file : files){
//            if(!file.isEmpty()){
//                // uuid, imgname, contenttype, uid
//                ProductImage pi = new ProductImage(
//                        UUID.randomUUID().toString(),
//                        "ImageName",
//                        file.getContentType(),
//                        p.getUid());
//                service.uploadProductImage(pi);
//
//                File newFile = new File(pi.getUuid());
//                file.transferTo(newFile);
//            }
//        }


        return "redirect:/";
    }
}
