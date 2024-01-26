package org.example.mathsapp.Model;

import org.example.mathsapp.TM.MarkFeeViewTM;
import org.example.mathsapp.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarkFeeModel {
    public static ArrayList<MarkFeeViewTM> MarkFeeView(String studentId) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("SELECT student.Student_ID, student.Name, student.Grade, student.Mobile_Number, feesmark.Month, feesmark.Date_Time FROM student, feesmark where student.Student_ID=? AND feesMark.Student_ID=?");
            stm.setObject(1,studentId);
            stm.setObject(2,studentId);

            ResultSet resultSet = stm.executeQuery();

            ArrayList<MarkFeeViewTM> list = new ArrayList<>();

            while (resultSet.next()) {
                MarkFeeViewTM tm = new MarkFeeViewTM();

                tm.setStudentID(resultSet.getString(1));
                tm.setName(resultSet.getString(2));
                tm.setGrade(String.valueOf(resultSet.getInt(3)));
                tm.setPhoneNumber(String.valueOf(resultSet.getInt(4)));
                tm.setFees(resultSet.getString(5));
                tm.setDate_time(resultSet.getString(6));

                list.add(tm);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean MarkClassFee(String Month_Price, String student_ID, String DateAndTime) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO feesmark (Student_ID, Month, Date_Time) VALUES (?,?,?)");
            stm.setObject(1,student_ID);
            stm.setObject(2,Month_Price);
            stm.setObject(3,DateAndTime);

            int results = stm.executeUpdate();

            if (results>0) {
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
