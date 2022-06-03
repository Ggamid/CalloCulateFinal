package com.example.myapplication;

public class Child {
    public String  firstName, lastName, fatherName, birthDay, height = "", weight = "";

    public Child() {
    }

    public Child(String firstName, String lastName, String fatherName, String birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthDay = birthDay;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getBirthDay() {
        return birthDay;
    }
}
