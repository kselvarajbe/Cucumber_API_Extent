package com.api.model;

public class StudentID {

    private String id;

    public String getStudentid() {
        return id;
    }

    public void setStudentid(String id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+"]";
    }



}
