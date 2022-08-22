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

    private int prd_price;
    // 상품업체
    @NotBlank
    private String prd_cmp;
    // 상품종류
    @NotBlank
    private String prd_type;
    // 상품 내용
    @NotBlank
    private String prd_ment;
    // 판매 수량

    private int prd_sales;
}
