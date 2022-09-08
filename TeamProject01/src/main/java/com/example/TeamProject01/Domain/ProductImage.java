package com.example.TeamProject01.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductImage {

    private String uuid;
    private int productid; //product uid
    private String imgname;
    private String contenttype;

    public ProductImage(String uuid, String imgname, String contenttype, @NotNull int productid){

        this.uuid = uuid;
        this.imgname = imgname;
        this.contenttype = contenttype;
        this.productid = productid; // product의 uid
    }

}
