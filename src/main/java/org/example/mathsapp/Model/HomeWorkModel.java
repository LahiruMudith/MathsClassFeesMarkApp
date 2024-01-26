package org.example.mathsapp.Model;


import org.example.mathsapp.TM.HomeWorkTM;
import org.example.mathsapp.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HomeWorkModel {
    public static ArrayList<HomeWorkTM> Search(int grade) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * from student where Grade=?");
            stm.setObject(1,grade);

            ResultSet resultSet = stm.executeQuery();

            ArrayList<HomeWorkTM> list = new ArrayList<>();

            while (resultSet.next()) {
                HomeWorkTM tm = new HomeWorkTM();

                tm.setStudentID(resultSet.getString(2));
                tm.setName(resultSet.getString(1    ));
                tm.setGrade(resultSet.getInt(6));
                tm.setWhatsappNumber(resultSet.getInt(3));
                tm.setMobileNumber(resultSet.getInt(4));
                tm.setAddress(resultSet.getString(7));

                list.add(tm);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
