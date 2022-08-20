package com.example.TeamProject01.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class InquiryForm {

    @NotBlank
    private String b_title;

    @NotBlank
    private String b_writer;

    @NotBlank
    private String b_pwd;

    @NotBlank
    private String b_category;

    @NotBlank
    private String ment;


}
