package com.example.TeamProject01.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter @Setter
public class Inquiry {

    private int uid;

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


    private Date b_date;
    private long p_time;

}
