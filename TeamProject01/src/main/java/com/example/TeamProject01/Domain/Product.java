package com.example.TeamProject01.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Data
public class Product {

    // 상품관리번호(자동생성)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    // 상품명
    @NotBlank(message = "상품명을 입력해주세요")
    private String prd_name;

    // 상품가격 : Int 변수는 꼭 NotBlank가 아닌 NotNull을 써야 함!
    @NotNull
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
    @NotNull
    private int prd_sales;


}
