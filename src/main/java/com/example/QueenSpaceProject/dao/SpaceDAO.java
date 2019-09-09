package com.example.QueenSpaceProject.dao;

import com.example.QueenSpaceProject.models.Facts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpaceDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Facts> getAll() {
        return jdbcTemplate.query("select * from space_schema.galaxy", new SpaceRowMapper());
    }

    public void addSpaceFact(Facts galaxy){
        System.out.println("Inserting " + galaxy);




    }
}
