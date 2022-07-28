package com.example.TeamProject01.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter

public class MemberForm {

    @NotBlank
    @Email
    private String email01;

    @NotBlank
    private String id01;

    @NotBlank
    private String pwd01;

    @NotBlank
    private String name01;
    @NotBlank
    private String n_name;
    @NotBlank
    private String addr01;
    @NotBlank
    private String addr02;
    @NotBlank
    private String addr03;

}
