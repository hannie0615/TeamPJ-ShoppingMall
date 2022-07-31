package com.example.TeamProject01.repository;

import com.example.TeamProject01.Domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class JdbcTemplateProductRepository implements ProductRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateProductRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Product saveProduct(Product p) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("product").usingGeneratedKeyColumns("uid");

        // parameters 입력
        Map <String, Object> parameters = new HashMap<>();
        parameters.put("prd_name", p.getPrd_name());
        parameters.put("prd_price", p.getPrd_price());
        parameters.put("prd_cmp", p.getPrd_cmp());
        parameters.put("prd_type", p.getPrd_type());
        parameters.put("prd_img", p.getPrd_img());
        parameters.put("realfile", p.getRealfile());
        parameters.put("prd_ment", p.getPrd_ment());
        parameters.put("prd_stock", p.getPrd_stock());

        // uid 설정
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        p.setUid(key.intValue());
        return p;

    }
}
