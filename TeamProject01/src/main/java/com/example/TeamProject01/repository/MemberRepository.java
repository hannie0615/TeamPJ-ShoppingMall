package com.example.TeamProject01.repository;

import com.example.TeamProject01.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {


}
