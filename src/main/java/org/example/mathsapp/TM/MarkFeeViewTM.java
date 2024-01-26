package org.example.mathsapp.TM;

public class MarkFeeViewTM {

    private String studentID;
    private String name;
    private String grade;
    private String phoneNumber;
    private String fees;
    private String date_time;

    public MarkFeeViewTM() {
    }

    public MarkFeeViewTM(String studentID, String name, String grade, String phoneNumber, String fees, String date_time) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.fees = fees;
        this.date_time = date_time;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
