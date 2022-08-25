package com.example.TeamProject01.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class Product {

    // 상품관리번호(자동생성)
    @NotBlank
    private int uid;

    // 상품명
    @NotBlank(message = "상품명을 입력해주세요")
    private String prd_name;

    // 상품가격
    @NotBlank(message = "상품 가격을 입력해주세요")
    private int prd_price;

    // 상품업체
    @NotBlank(message = "상품 업체를 입력해주세요")
    private String prd_cmp;

    // 상품종류
    @NotBlank(message = "상품 종류를 입력해주세요")
    private String prd_type;

    // 상품 내용
    @NotBlank(message = "상품 내용을 입력해주세요")
    private String prd_ment;

    // 판매 수량
    @NotBlank(message = "판매 수량을 입력해주세요")
    private int prd_sales;


}
