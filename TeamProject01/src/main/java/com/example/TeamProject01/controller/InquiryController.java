package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Inquiry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class InquiryController {

    @PostMapping("myPage/myInquiry")
    public String create(){
        // 우리는 사용자가 입력한 name 값을 가지고 객체를 만듦
        Date date = new Date();
        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        return "myPage/myInquiry";
    }
}
