package com.example.myapplication;

public class Child {
    public String  firstName, lastName, fatherName, birthDay, smes, age, weight, id;

    public Child(String firstName, String lastName, String fatherName, String birthDay, String age, String weight, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthDay = birthDay;
        this.age = age;
        this.weight = weight;
        this.id = id;
    }

    public Child(){}

    public String getSmes() {
        return smes;
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

    public String getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getWeight() {
        return weight;
    }
}
