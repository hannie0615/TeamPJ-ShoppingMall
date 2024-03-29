package com.example.TeamProject01;

import com.example.TeamProject01.repository.*;
import com.example.TeamProject01.service.InquiryService;
import com.example.TeamProject01.service.MemberService;
import com.example.TeamProject01.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;


    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    /*
        Controller는 이 페이지에 모으지 않는다.

        왜냐하면, 원래부터 스프링은
     */

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepositoryInterface());
    }
    // 2. 이 인터페이스함수를 MemberService 에 포함을 하도록 한다.
    @Bean
    public MemberRepositoryInterface memberRepositoryInterface() {
        return new JdbcTemplateMemberRepository(dataSource);
    }

    @Bean
    public InquiryService inquiryService() {
        return new InquiryService(inquiryRepositoryInterface());
    }

    @Bean
    public InquiryRepositoryInterface inquiryRepositoryInterface() {
        return new JdbcTemplateInquiryRepository(dataSource);
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepositoryInterface());
    }

    @Bean
    public ProductRepositoryInterface productRepositoryInterface() {
        return new JdbcTemplateProductRepository(dataSource);
    }
}
