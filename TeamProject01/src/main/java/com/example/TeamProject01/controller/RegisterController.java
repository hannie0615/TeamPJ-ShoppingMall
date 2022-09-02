package com.example.TeamProject01.controller;

import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    MemberService service;

    @Autowired
    public RegisterController(MemberService service) {
        this.service = service;
    }

    @PostMapping // 슬러쉬를 붙이지 않으면 이전의 URL 뒤에 이어서 URL 이 나옴, 그리고 슬러쉬를 붙이면
    // Localhost: XXXX 뒤에 이어서 나옴
    public String create(@Valid Member m) throws ParseException {
        // 우리는 사용자가 입력한 name 값을 가지고 객체를 만듦

        // DB에 넣어야 함.

        service.save(m); // 여기에다가 memberForm 을 그대로 때려 넣는것은 좀 아님.
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/idcheck")
    public int idchecked(@RequestParam("id") String id){
        int data = service.idCheck(id);
        return data;
    }

    @ResponseBody
    @GetMapping("/nicknameCheck")
    public int nicknameCheck(@RequestParam("nickname") String n_name) {
        int data = service.nicknameCheck(n_name);
        return data;
    }

    @ResponseBody
    @GetMapping("/mailCheck")
    public int emailCheck(@RequestParam("mail") String email) {
        int data = service.emailCheck(email);
        return data;
    }

}
