package com.example.TeamProject01.repository;

import com.example.TeamProject01.Domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member saveMember(Member m) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        // SimpleJdbcInsert = Connection , Statement 를 잡아주는 역할.
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        // Member 이라는 테이블에 id 키를 만들어 달라는 것, RETURN_GENERATED_KEY 랑 동일
        // ID와 Name 값에서 ID 값을 usingGeneratedKeyColumns 로 고정
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("email01", m.getEmail01());
        parameters.put("id01", m.getId01());
        parameters.put("pwd01", m.getPwd01());
        parameters.put("name01", m.getName01());
        parameters.put("n_name", m.getN_name());
        parameters.put("addr01", m.getAddr01());
        parameters.put("addr02", m.getAddr02());
        parameters.put("addr03", m.getAddr03());
        parameters.put("r_date01", m.getR_date01());
        parameters.put("p_time", m.getP_time());



        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        m.setUid(key.intValue());
        return m;
    }

    @Override
    public int idDuplicateCheck(String id) {
        int data = 1;

        List<Member> result = jdbcTemplate.query("SELECT * FROM shoppingmall.member WHERE id01 = ?", memberRowMapper(),id);

        if (result.isEmpty()) {
            data = 0;
        }
        return data;
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("SELECT * FROM shoppingmall.member", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper(){
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setEmail01(rs.getString("email01"));
            member.setId01(rs.getString("id01"));
            member.setPwd01(rs.getString("pwd01"));
            member.setName01(rs.getString("name01"));
            member.setN_name(rs.getString("n_name"));
            member.setAddr01(rs.getString("addr01"));
            member.setAddr02(rs.getString("addr02"));
            member.setAddr03(rs.getString("addr03"));
            member.setR_date01(rs.getDate("r_date01"));
            member.setP_time(rs.getTimestamp("p_time"));
            return member;
        };
    }


}
