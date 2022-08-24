package com.example.TeamProject01.repository;

import com.example.TeamProject01.Domain.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplateInquiryRepository implements InquiryRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateInquiryRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Inquiry saveInquiry(Inquiry i) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("inquiry_board").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("b_title", i.getB_title());
        parameters.put("b_writer", i.getB_writer());
        parameters.put("b_pwd", i.getB_pwd());
        parameters.put("b_category", i.getB_category());
        parameters.put("ment", i.getMent());
        parameters.put("b_date", i.getB_date());
        parameters.put("p_time", i.getP_time());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        i.setUid(key.intValue());
        return i;

    }

    @Override
    public List<Inquiry> findAll() {
        return jdbcTemplate.query("SELECT * FROM shoppingmall.inquiry_board", inquiryRowMapper());
    }

    private RowMapper<Inquiry> inquiryRowMapper() {
        return (rs, rowNum) -> {
            Inquiry inquiry = new Inquiry();
            inquiry.setB_title(rs.getString("b_title"));
            inquiry.setB_writer(rs.getString("b_writer"));
            inquiry.setB_pwd(rs.getString("b_pwd"));
            inquiry.setB_category(rs.getString("b_category"));
            inquiry.setMent(rs.getString("ment"));
            inquiry.setB_date(rs.getDate("b_date"));
            inquiry.setP_time(rs.getLong("p_time"));
            return inquiry;
        };
    }
}
