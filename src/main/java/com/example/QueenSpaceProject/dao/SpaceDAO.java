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

    public void addSpaceFact(Facts galaxy) {
        System.out.println("Inserting " + galaxy);
        jdbcTemplate.update("INSERT INTO space_schema.galaxy(fact) VALUES (?) ", galaxy.getFact());
    }

    public void updateSpaceFact(int id, Facts galaxy) {
        System.out.println("Updating: " + galaxy);
        jdbcTemplate.update("UPDATE space_schema.galaxy SET fact=? where id=?", galaxy.getFact(), id);
    }

    public Facts findById(int id) {
        List<Facts> matches = jdbcTemplate.query("select * from space_schema.galaxy where id = ?",
                new Object[]{id},
                new SpaceRowMapper());
        if (matches.isEmpty()) {
            return null;
        } else {
            return matches.get(0);
        }
    }

    public List<Facts> findByString(String keyword) {
        System.out.println("Finding fact by searching strings...");
        return jdbcTemplate.query("select * from space_schema.galaxy where fact like ? ", new SpaceRowMapper(), "%" + keyword + "%");
    }
}



