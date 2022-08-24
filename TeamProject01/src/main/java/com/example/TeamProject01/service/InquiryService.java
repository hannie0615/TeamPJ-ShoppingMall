package com.example.TeamProject01.service;

import com.example.TeamProject01.Domain.Inquiry;
import com.example.TeamProject01.Domain.Member;
import com.example.TeamProject01.repository.InquiryRepositoryInterface;
import com.example.TeamProject01.repository.MemberRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class InquiryService {

    private InquiryRepositoryInterface repository;

    @Autowired
    public InquiryService(InquiryRepositoryInterface repository){
        this.repository = repository;
    }

    public void join(Inquiry i) {
        repository.saveInquiry(i);
    }
}
