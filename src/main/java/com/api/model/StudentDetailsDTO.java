package com.api.model;

public class StudentDetailsDTO {

    private String firstname;

    private String lastname;

    private String id;

    private String nationality;

    private String studentClass;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [firstname = "+firstname+", lastname = "+lastname+", id = "+id+", nationality = "+nationality+", studentClass = "+studentClass+",]";
    }


}
