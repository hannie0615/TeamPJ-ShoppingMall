package com.example.TeamProject01.service;

import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.Domain.Role;
import com.example.TeamProject01.repository.MemberRepository;
import com.example.TeamProject01.repository.MemberRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private MemberRepositoryInterface repository;

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member save(Member member){

        Date date = new Date();
        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        member.setR_date01(date1);
        member.setP_time(timestamp.getTime());
        String encodedPassword = passwordEncoder.encode(member.getPwd01());
        member.setPwd01(encodedPassword);
        member.setEnabled(true);
        Role role = new Role();
        role.setId(1);
        member.getRoles().add(role);

        return memberRepository.save(member);
    }

    // new 를 이용해서 객체를 생성하지 않고 생성자를 통해서 기존에 생성된 객체를 계속 사용한다.
    @Autowired
    public MemberService(MemberRepositoryInterface repository){
        this.repository = repository;
    }

    public void join(Member m) {
        repository.saveMember(m);
    }

    public int idCheck(String id) {
        return repository.idDuplicateCheck(id);
    }

    public List<Member> findAllMember() {
        return repository.findAll();
    }

    public int nicknameCheck(String id) {
        return repository.nicknameDuplicateCheck(id);
    }

    public int emailCheck(String mail) {
        return repository.mailDuplicateCheck(mail);
    }
}
