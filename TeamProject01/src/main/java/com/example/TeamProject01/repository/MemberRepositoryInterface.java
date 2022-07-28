package com.example.TeamProject01.repository;

import com.example.TeamProject01.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoryInterface {

    Member saveMember(Member m);
    int idDuplicateCheck(String id);
    List<Member> findAll();

}
