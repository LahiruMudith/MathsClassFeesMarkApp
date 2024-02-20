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

public class DeleteStudentController {
    @FXML
    private AnchorPane root;

    @FXML
    private javafx.scene.layout.Pane Pane;

    @FXML
    private TextField txtSearchStudentID;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtGrade;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtWhatsappNumber;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtStudentID;

    @FXML
    private TextField txtphoneNumber;
    @FXML
    void KeySearch(ActionEvent event) {
        String studentId = txtSearchStudentID.getText();
        System.out.println(studentId);

        Student student = StudentModel.SearchStudent(studentId);
        System.out.println(student.getName());

        txtName.setText(student.getName());
        txtStudentID.setText(student.getStudentID());
        txtWhatsappNumber.setText(String.valueOf(student.getWhatsappNumber()));
        txtphoneNumber.setText(String.valueOf(student.getPhoneNumber()));
        txtEmail.setText(student.getEmail());
        txtGrade.setText(String.valueOf(student.getGrade()));
        txtAddress.setText(student.getAddress());
    }

    @FXML
    void SearchStudent(MouseEvent event) {
        String studentId = txtSearchStudentID.getText();

        Student student = StudentModel.SearchStudent(studentId);
        System.out.println(student.getName());

        txtName.setText(student.getName());
        txtStudentID.setText(student.getStudentID());
        txtWhatsappNumber.setText(String.valueOf(student.getWhatsappNumber()));
        txtphoneNumber.setText(String.valueOf(student.getPhoneNumber()));
        txtEmail.setText(student.getEmail());
        txtGrade.setText(String.valueOf(student.getGrade()));
        txtAddress.setText(student.getAddress());
    }

    @FXML
    void studentAdd(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Add-Student-view.fxml"));
            Pane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void StudentUpdate(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Update-Student-view.fxml"));
            Pane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void studentDelete(MouseEvent event) {
        String studentId = txtSearchStudentID.getText();

        boolean b = StudentModel.DeleteStudent(studentId);

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Student Delete Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Student Delete Fail");
            alert.show();
        }
    }

    public void clear() {
        txtSearchStudentID.setText("");
        txtStudentID.setText("");
        txtName.setText("");
        txtphoneNumber.setText("");
        txtAddress.setText("");
        txtGrade.setText("");
        txtWhatsappNumber.setText("");
        txtEmail.setText("");
    }

}
