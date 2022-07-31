package com.example.TeamProject01.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class ProductForm {

    // 상품명
    @NotBlank
    private String prd_name;
    // 상품가격
    @NotBlank
    private int prd_price;
    // 상품업체
    @NotBlank
    private String prd_cmp;
    // 상품종류
    @NotBlank
    private String prd_type;
    // 상품 이미지 파일
    @NotBlank
    private String prd_img;
    // 실제 상품 이미지 파일
    @NotBlank
    private String realfile;
    // 상품 내용
    @NotBlank
    private String prd_ment;
    // 상품 재고
    @NotBlank
    private int prd_stock;
    // 판매 수량
    @NotBlank
    private int prd_sales;
}
