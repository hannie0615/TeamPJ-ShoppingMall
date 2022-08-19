package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;


@Controller
public class pageController {

    MemberService service;

    @Autowired
    public pageController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/aboutUs")
    public String goAboutUs(){
        return "contact/aboutUs";
    }

    @PostMapping("/register")
    public String goRegister() {
        return "member/register";
    }

    @PostMapping("/login")
    public String goLogin() {
        return "member/login";
    }

    @GetMapping("/test")
    public String goTest() {
        return "insertTest";
    }

    //contact-us
    @GetMapping("contactus")
    public String gocontact(Model model) {
        return "inquiry/contact-us";
    }

    // aboutUs
    @GetMapping("aboutus")
    public String goabout(Model model) {
        return "contact/aboutUs";
    }

    // 배송조회
    @GetMapping("delivsch")
    public String godelivsch(Model model) {
        return "delivery/delivery-search";
    }

    // 상품등록
    @PostMapping("/addlist")
    public String goAddList(){
        return "product/addProduct";
    }

    // 관리자용 상품조회
    @GetMapping("/product")
    public String goproduct(Model model) {
        return "product/manageProduct";
    }

    // 주문내역
    @GetMapping("order")
    public String goorder(Model model) {
        return "myPage/myOrder";
    }

    // 관심목록
    @GetMapping("like")
    public String golike(Model model) {
        return "myPage/myLike";
    }

    // 문의내역
    @GetMapping("inquiry")
    public String goinquiry(Model model) {
        return "myPage/myInquiry";
    }

    // 장바구니
    @GetMapping("cart")
    public String gocart(Model model) {
        return "myPage/myCart";
    }

    // 리뷰내역
    @GetMapping("review")
    public String goreview(Model model) {
        return "myPage/myReview";
    }

}
