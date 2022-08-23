package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.Domain.ProductImage;
import com.example.TeamProject01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
