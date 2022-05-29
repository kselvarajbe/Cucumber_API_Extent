package com.api.model;

public class StudentDTO{

    private StudentDetailsDTO student;

    public StudentDetailsDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDetailsDTO student) {
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    @Override
    public String toString()
    {
        return "ClassPojo [student = "+student+", id = "+id+"]";
    }
}
