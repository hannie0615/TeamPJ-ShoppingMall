package com.example.TeamProject01.repository;

import com.example.TeamProject01.Domain.Inquiry;
import com.example.TeamProject01.Domain.Member;

import java.util.List;

public interface InquiryRepositoryInterface {

    Inquiry saveInquiry(Inquiry i);
    List<Inquiry> findAll();
}
