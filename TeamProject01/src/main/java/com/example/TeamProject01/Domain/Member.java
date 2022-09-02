package com.example.TeamProject01.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @NotBlank(message = "mail is blank")
    @Email
    private String email01;

    @NotBlank(message = "id is blank")
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


    private Date r_date01;
    private long p_time;

    private boolean enabled;

    @ManyToMany
    @JoinTable(
            name = "member_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();
}
