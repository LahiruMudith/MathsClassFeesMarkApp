package org.example.mathsapp.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.mathsapp.Model.MarkFeeModel;
import org.example.mathsapp.Model.StudentModel;
import org.example.mathsapp.TM.MarkFeeViewTM;
import org.example.mathsapp.TO.Student;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FeesMarkController implements Initializable {
    @FXML
    private ComboBox month;

    @FXML
    private TableView<MarkFeeViewTM> tblMarkFee;

    @FXML
    private TextField txtSearchStudentID;

    @FXML
    private TextField txtPrice;

    @FXML
    void CopyButton(MouseEvent event) {

    }

    @FXML
    void KeySearch(ActionEvent event) {
        String studentId = txtSearchStudentID.getText();

        ArrayList<MarkFeeViewTM> list = MarkFeeModel.MarkFeeView(studentId);
        tblMarkFee.setItems(FXCollections.observableArrayList(list));

    }
    @FXML
    void SearchStudent(MouseEvent event) {
        String studentId = txtSearchStudentID.getText();

        ArrayList<MarkFeeViewTM> list = MarkFeeModel.MarkFeeView(studentId);
        tblMarkFee.setItems(FXCollections.observableArrayList(list));

    }
    @FXML
    void MarkFee(MouseEvent event) {
        String student_ID = txtSearchStudentID.getText();
        String Month = month.getSelectionModel().getSelectedItem().toString();
        int Price = Integer.parseInt(txtPrice.getText());
        String Month_Price = Month +" "+ Price;

        Student student = StudentModel.SearchStudent(student_ID);
        String name = student.getName();
        int grade = student.getGrade();

        int monthClassFee = 0;
        if (grade<=8) {
            monthClassFee = 700;
        } else if (grade>=9 && grade<=11) {
            monthClassFee = 800;
        } else if (grade==12) {
            monthClassFee = 2500;
        }

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String DateAndTime = myDateObj.format(myFormatObj);

        boolean b = MarkFeeModel.MarkClassFee(Month_Price, student_ID, DateAndTime);

        String message = ( name + " (" + student_ID + ") - Grade " + grade + "\n" +
                "\n" +
                "ආදරනීය දෙමා පියනි,\n"+
                Month + " මාසය සඳහා ඔබේ දරුවා ගේ පන්ති ගාස්තු ගෙවීම සාර්ථකයි.\n" +
                "මාසික ගාස්තුව : රු. " +monthClassFee+ " \n" +
                "ගෙවූ මුදල : රු. " +Price+"\n" +
                "දිනය : " +DateAndTime+ "\n" +
                "\n" +
                "Thank you ! \n" +
                "Sahan Rasanjana.").formatted();
        javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
        javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
        content.putString(message);
        clipboard.setContent(content);


        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Class Fee Done");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Class Fee Mark Fail");
            alert.show();
        }
    }

    @FXML
    void select(ActionEvent event) {
        String Month = month.getSelectionModel().getSelectedItem().toString();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        month.setItems(list);

        tblMarkFee.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentID"));
        tblMarkFee.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMarkFee.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("grade"));
        tblMarkFee.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tblMarkFee.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("fees"));
        tblMarkFee.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("date_time"));

        tblMarkFee.getSelectionModel().setCellSelectionEnabled(true);
        tblMarkFee.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void clear() {
        txtSearchStudentID.setText("");
        txtPrice.setText("");
    }
}
