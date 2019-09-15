package com.example.QueenSpaceProject.dao;

import com.example.QueenSpaceProject.models.Facts;
import org.springframework.jdbc.core.RowMapper;

//import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpaceRowMapper implements RowMapper<Facts> {

    public Facts mapRow(ResultSet resultSet, int IgnoreThis) throws SQLException {
        int id;
        String fact;

        id = resultSet.getInt("id");
        fact = resultSet.getString("fact");
        return new Facts(id, fact);
//in this method, it was string spaceFact, spaceFact = resultSet, return new Facts(spaceFact)
        //so I changed those to fact to match DAO to see if it helped

    }

}
