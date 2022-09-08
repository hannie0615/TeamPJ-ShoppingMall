package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Inquiry;
import com.example.TeamProject01.service.InquiryService;
import com.example.TeamProject01.service.MemberService;
import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

@Controller
public class InquiryController {

    @Autowired
    InquiryService service;

    @Autowired
    public InquiryController(InquiryService service) {
        this.service = service;
    }

    @PostMapping("myPage/myInquiry")
    public String create(@Valid @NotNull Inquiry inqf) throws ParseException {
        // 우리는 사용자가 입력한 name 값을 가지고 객체를 만듦
        Date date = new Date();
        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Inquiry i = new Inquiry();
        i.setB_title(inqf.getB_title());
        i.setB_writer(inqf.getB_writer());
        i.setB_pwd(inqf.getB_pwd());
        i.setB_category(inqf.getB_category());
        i.setMent(inqf.getMent());
        i.setB_date(inqf.getB_date());
        i.setP_time(timestamp.getTime());

        service.join(i);
        return "myPage/myInquiry";
    }

}
