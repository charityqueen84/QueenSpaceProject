package com.example.QueenSpaceProject.dao;

import com.example.QueenSpaceProject.models.Facts;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpaceRowMapper implements RowMapper<Facts> {

    public Facts mapRow(ResultSet resultSet, int IgnoreThis) throws SQLException {
        String spaceFact;


        spaceFact = resultSet.getString("fact");

        return new Facts(spaceFact);


    }

}
