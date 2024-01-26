package org.example.mathsapp.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.mathsapp.Model.HomeWorkModel;
import org.example.mathsapp.Model.StudentModel;
import org.example.mathsapp.TM.HomeWorkTM;
import org.example.mathsapp.TO.Student;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeWorkController implements Initializable {
    @FXML
    private TableColumn<HomeWorkTM, String> colAddress;

    @FXML
    private TableColumn<HomeWorkTM, Integer> colGrade;

    @FXML
    private TableColumn<HomeWorkTM, String> colID;

    @FXML
    private TableColumn<HomeWorkTM, Integer> colMobileNumber;

    @FXML
    private TableColumn<HomeWorkTM, String> colName;

    @FXML
    private TableColumn<HomeWorkTM, Integer> colWhatsappNumber;

    @FXML
    private TextField txtStudentID;

    @FXML
    private TableView<HomeWorkTM> tblStudentDetails;

    @FXML
    private TextField txtStudentsGrade;

    @FXML
    void HomeWorkDone(MouseEvent event) {
        Integer index = tblStudentDetails.getSelectionModel().getSelectedIndex();
        String studenID = colID.getCellData(index).toString();
        String name = colName.getCellData(index).toString();
        String grade = colGrade.getCellData(index).toString();


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();
        String BeforeDate = dateFormat.format(todate1);


        String message = (name + "( " + studenID + " ) - Grade " + grade + "\n" +
                "\n" +
                "ආදරනීය දෙමාපියනි,\n" +
                "\n" +
                BeforeDate + " දිනට අදාළ  පැවරුම් ඔබේ දරුවා  නිසියාකාරව සිදුකර ඇත...\n" +
                "\n" +
                "Thank you .\n" +
                "Sahan Rasanjana.").formatted();

        javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
        javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
        content.putString(message);
        clipboard.setContent(content);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Home Work Done Message Copied successfully");
        alert.show();
    }

    @FXML
    void HomeWorkWrong(MouseEvent event) {
        Integer index = tblStudentDetails.getSelectionModel().getSelectedIndex();
        String studenID = colID.getCellData(index).toString();
        String name = colName.getCellData(index).toString();
        String grade = colGrade.getCellData(index).toString();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();
        String BeforeDate = dateFormat.format(todate1);

        String message = (name + "( " + studenID + " ) - Grade " + grade + "\n" +
                "\n" +
                "ආදරනීය දෙමාපියනි,\n" +
                "\n" +
                BeforeDate + " දිනට අදාළ  පැවරුම් ඔබේ දරුවා  නිසියාකාරව සිදුකර නැත...\n" +
                "එම කරුණ සම්බන්ධයෙන් පැමිණ මා හමුවන්න.....\n" +
                "\n" +
                "Thank you .\n" +
                "Sahan Rasanjana.").formatted();
        javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
        javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
        content.putString(message);
        clipboard.setContent(content);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Home Work Wrong Message Copied successfully");
        alert.show();
    }


    @FXML
    void NotAttendingClass(MouseEvent event) {
        Integer index = tblStudentDetails.getSelectionModel().getSelectedIndex();
        String studenID = colID.getCellData(index).toString();
        String name = colName.getCellData(index).toString();
        String grade = colGrade.getCellData(index).toString();

        LocalDate Date = LocalDate.now();

        String message = (name + "( " + studenID + " ) - Grade " + grade + "\n" +
                "\n" +
                "ආදරනීය දෙමාපියනි,\n" +
                "\n" +
                Date + " දින ඔබේ දරුවා පන්තිට සහභාගි නොවීය...\n" +
                "\n" +
                "Thank you !\n" +
                "Sahan Rasanjana.").formatted();
        javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
        javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
        content.putString(message);
        clipboard.setContent(content);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Not Attend Message Copied successfully");
        alert.show();
    }

    @FXML
    void KeySearch(ActionEvent event) {
        int grade = Integer.parseInt(txtStudentsGrade.getText());

        ArrayList<HomeWorkTM> list = HomeWorkModel.Search(grade);

        tblStudentDetails.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    void SearchStudentsGrade(MouseEvent event) {
        int grade = Integer.parseInt(txtStudentsGrade.getText());

        ArrayList<HomeWorkTM> list = HomeWorkModel.Search(grade);

        tblStudentDetails.setItems(FXCollections.observableArrayList(list));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblStudentDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentID"));
        tblStudentDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudentDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("grade"));
        tblStudentDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("whatsappNumber"));
        tblStudentDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        tblStudentDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("address"));
    }
}
