package com.dao;

import com.entity.Pamht;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PamhtDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Pamht findByidPamht(int id){
        final Pamht pamht=new Pamht();
        String sql="select name,score from pamht where id=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                pamht.setName(resultSet.getString(1));
                pamht.setScore(resultSet.getInt(2));
            }
        });
        return pamht;
    }

    public Pamht findByNamePamht(String name){
        final Pamht pamht=new Pamht();
        String sql="select name,score from pamht where name=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                pamht.setName(resultSet.getString(1));
                pamht.setScore(resultSet.getInt(2));
            }
        });
        return pamht;
    }

}
