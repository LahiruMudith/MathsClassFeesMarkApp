package org.example.mathsapp.TO;

public class Student {
    private String Name;
    private String StudentID;
    private int PhoneNumber;
    private int WhatsappNumber;
    private String Email;
    private int Grade;
    private String Address;

    public Student() {
    }

    public Student(String name, String studentID, int phoneNumber, int whatsappNumber, String email, int grade, String address) {
        Name = name;
        StudentID = studentID;
        PhoneNumber = phoneNumber;
        WhatsappNumber = whatsappNumber;
        Email = email;
        Grade = grade;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getWhatsappNumber() {
        return WhatsappNumber;
    }

    public void setWhatsappNumber(int whatsappNumber) {
        WhatsappNumber = whatsappNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
