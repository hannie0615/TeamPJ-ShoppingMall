package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.Domain.Product;
import com.example.TeamProject01.Domain.ProductImage;
import com.example.TeamProject01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/newproduct")
public class ProductController {
    @Autowired
    ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }

    @PostMapping
    public String createProduct(@RequestParam MultipartFile[] uploadfile, Model model, @Valid Product p) throws ParseException, IOException {

        // product DB에 넣기
        service.save(p);

        // product Img DB에 넣기
        List<ProductImage> list = new ArrayList<>();
        for(MultipartFile file : uploadfile){
            if(!file.isEmpty()){
                // uuid, imgname, contenttype, uid
                ProductImage pi = new ProductImage(
                        UUID.randomUUID().toString(),
                        file.getOriginalFilename(),
                        file.getContentType(),
                        p.getUid() // product의 uid를 productid로 가져오기.
                );
                list.add(pi);
                service.uploadImage(pi);

                // pc 로컬 위치에 저장
                File newFile = new File(pi.getUuid()+ "_" +pi.getImgname());
                file.transferTo(newFile);
            }
        }
        model.addAttribute("files",list);

        return "redirect:/";
    }
}
