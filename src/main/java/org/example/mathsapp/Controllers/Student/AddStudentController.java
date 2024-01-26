package org.example.mathsapp.Controllers.Student;

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

public class AddStudentController {
    @FXML
    private AnchorPane root;

    @FXML
    private Pane Pane;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtGrade;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtWhatsappNumber;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtStudentID;

    @FXML
    private TextField txtphoneNumber;

    @FXML
    void studentAdd(MouseEvent event) {
        String name = txtName.getText();
        String studentID = txtStudentID.getText();
        int phoneNumber = Integer.parseInt(txtphoneNumber.getText());
        int whatsappNumber = Integer.parseInt(txtWhatsappNumber.getText());
        String email = txtEmail.getText();
        int grade = Integer.parseInt(txtGrade.getText());
        String address = txtAddress.getText();

        boolean b = StudentModel.AddStudent(new Student(name, studentID, phoneNumber, whatsappNumber, email, grade, address));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Student Add Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Student Add Fail");
            alert.show();
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
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Delete-Student-view.fxml"));
            Pane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clear() {
        txtName.setText("");
        txtStudentID.setText("");
        txtphoneNumber.setText("");
        txtWhatsappNumber.setText("");
        txtEmail.setText("");
        txtGrade.setText("");
        txtAddress.setText("");
    }
}
