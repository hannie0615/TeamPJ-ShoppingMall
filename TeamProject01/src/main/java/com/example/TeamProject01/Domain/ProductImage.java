package com.example.TeamProject01.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class ProductImage {

    private String uuid;
    private int uid;
    private String imgname;
    private String contenttype;

    public ProductImage(String uuid, String imageName, String contentType, @NotBlank int uid){

        this.uuid = uuid;
        this.imgname = imgname;
        this.contenttype = contenttype;
        this.uid = uid;
    }

}
