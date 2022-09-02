package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.Domain.ProductImage;
import com.example.TeamProject01.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }


    @PostMapping("/newproduct")
    public String createProduct(@RequestParam MultipartFile[] uploadfile, Model model, @Valid ProductForm pf) throws ParseException, IOException {

        Product p = new Product();

        p.setPrd_name(pf.getPrd_name());
        p.setPrd_price(pf.getPrd_price());
        p.setPrd_cmp(pf.getPrd_cmp());
        p.setPrd_type(pf.getPrd_type());
        p.setPrd_ment(pf.getPrd_ment());
        p.setPrd_sales(pf.getPrd_sales());

        service.add(p); // product DB에 넣기

        List<ProductImage> list = new ArrayList<>();

        for(MultipartFile file : uploadfile){
            if(!file.isEmpty()){
                // uuid, imgname, contenttype, uid
                ProductImage pi = new ProductImage(
                        UUID.randomUUID().toString(),
                        file.getOriginalFilename(),
                        file.getContentType(),
                        p.getUid());
                list.add(pi);
                //service.uploadProductImage(pi);

                File newFile = new File(pi.getUuid()+ "_" +pi.getImgname());
                file.transferTo(newFile);
            }
        }
        model.addAttribute("files",list);

        return "redirect:/";
    }
}