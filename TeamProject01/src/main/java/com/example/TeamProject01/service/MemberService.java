package com.example.TeamProject01.service;

import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.repository.MemberRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private MemberRepositoryInterface repository;

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
}
