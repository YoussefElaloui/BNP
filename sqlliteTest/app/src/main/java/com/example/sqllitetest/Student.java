package com.example.sqllitetest;

public class Student {
    int id;
    String last_name;
    String first_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public Student(String last_name, String first_name) {
        this.last_name = last_name;
        this.first_name = first_name;
    }
    public Student(int id, String last_name, String first_name) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
    }


}
