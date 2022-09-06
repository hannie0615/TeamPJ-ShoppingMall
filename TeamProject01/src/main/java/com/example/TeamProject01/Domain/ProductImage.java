package com.example.TeamProject01.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductImage {

    private String uuid;
    private int uid; //product number
    private String imgname;
    private String contenttype;

    public ProductImage(String uuid, String imgname, String contenttype, @NotBlank int uid){

        this.uuid = uuid;
        this.imgname = imgname;
        this.contenttype = contenttype;
        this.uid = uid;
    }

}
