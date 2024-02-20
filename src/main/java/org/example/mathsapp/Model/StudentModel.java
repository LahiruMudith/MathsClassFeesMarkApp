package org.example.mathsapp.Model;

import org.example.mathsapp.TO.Student;
import org.example.mathsapp.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentModel {
    public static boolean AddStudent(Student student) {

        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
            stm.setObject(1,student.getName());
            stm.setObject(2,student.getStudentID());
            stm.setObject(3,student.getWhatsappNumber());
            stm.setObject(4,student.getPhoneNumber());
            stm.setObject(5,student.getEmail());
            stm.setObject(6,student.getGrade());
            stm.setObject(7,student.getAddress());

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

    public static Student SearchStudent(String studentId) {

        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("select * from student where Student_ID=?");
            stm.setObject(1,studentId);

            ResultSet resultSet = stm.executeQuery();

            Student student = new Student();

            while (resultSet.next()) {
                student.setName(resultSet.getString(1));
                student.setStudentID(resultSet.getString(2));
                student.setWhatsappNumber(resultSet.getInt(3));
                student.setPhoneNumber(resultSet.getInt(4));
                student.setEmail(resultSet.getString(5));
                student.setGrade(resultSet.getInt(6));
                student.setAddress(resultSet.getString(7));
            }
            return student;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean UpdateStudent(Student student) {

        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("update student set Name=?,Student_ID=?, Whatsapp_Number=?, Mobile_Number=?, Email=?, Grade=?, Address=? where Student_ID=?");
            stm.setObject(1,student.getName());
            stm.setObject(2,student.getStudentID());
            stm.setObject(3,student.getWhatsappNumber());
            stm.setObject(4,student.getPhoneNumber());
            stm.setObject(5,student.getEmail());
            stm.setObject(6,student.getGrade());
            stm.setObject(7,student.getAddress());
            stm.setObject(8,student.getStudentID());

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
    public static boolean DeleteStudent(String studentId) {

        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("DELETE student , feesmark FROM feesmark JOIN student ON  student.Student_ID=feesmark.Student_ID WHERE feesmark.Student_ID = ?");
            stm.setObject(1, studentId);

            int results = stm.executeUpdate();

            if (results > 0) {
                System.out.println("done");
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
