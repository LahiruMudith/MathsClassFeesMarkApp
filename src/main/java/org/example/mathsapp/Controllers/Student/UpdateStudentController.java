package org.example.mathsapp.Controllers.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.example.mathsapp.HelloApplication;
import org.example.mathsapp.Model.StudentModel;
import org.example.mathsapp.TO.Student;


import java.io.IOException;

public class UpdateStudentController {

    @FXML
    private javafx.scene.layout.Pane Pane;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtGrade;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtWhatsappNumber;

    @FXML
    private TextField txtStudentID;

    @FXML
    private TextField txtphoneNumber;

    @FXML
    private TextField txtSearchStudentID;

    @FXML
    void studentAdd(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Add-Student-view.fxml"));
            Pane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }    }

    @FXML
    void StudentUpdate(MouseEvent event) {
        String name = txtName.getText();
        String studentId = txtSearchStudentID.getText();
        int whatsappNumber = Integer.parseInt(txtWhatsappNumber.getText());
        int phoneNumber = Integer.parseInt(txtphoneNumber.getText());
        String email = txtEmail.getText();
        int grade = Integer.parseInt(txtGrade.getText());
        String address = txtAddress.getText();

        boolean b = StudentModel.UpdateStudent(new Student(name, studentId,whatsappNumber, phoneNumber, email, grade, address));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Student Update Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Student Update Fail");
            alert.show();
        }
    }


    @FXML
    void KeySearch(ActionEvent event) {
        String studentId = txtSearchStudentID.getText();

        Student student = StudentModel.SearchStudent(studentId);
        txtName.setText(student.getName());
        txtWhatsappNumber.setText(String.valueOf(student.getWhatsappNumber()));
        txtphoneNumber.setText(String.valueOf(student.getPhoneNumber()));
        txtEmail.setText(student.getEmail());
        txtGrade.setText(String.valueOf(student.getGrade()));
        txtAddress.setText(student.getAddress());
    }

    @FXML
    void studentDelete(MouseEvent event) { try {
        Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Delete-Student-view.fxml"));
        Pane.getChildren().setAll(load);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
    @FXML
    void SearchStudent(MouseEvent event) {
        String studentId = txtSearchStudentID.getText();

        Student student = StudentModel.SearchStudent(studentId);
        System.out.println(student.getName());

        txtName.setText(student.getName());
        txtWhatsappNumber.setText(String.valueOf(student.getWhatsappNumber()));
        txtphoneNumber.setText(String.valueOf(student.getPhoneNumber()));
        txtEmail.setText(student.getEmail());
        txtGrade.setText(String.valueOf(student.getGrade()));
        txtAddress.setText(student.getAddress());
    }

    public void clear() {
        txtName.setText("");
        txtSearchStudentID.setText("");
//        txtStudentID.setText("");
        txtWhatsappNumber.setText("");
        txtphoneNumber.setText("");
        txtEmail.setText("");
        txtGrade.setText("");
        txtAddress.setText("");
    }
}
