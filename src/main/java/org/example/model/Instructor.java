package org.example.model;

import java.util.ArrayList;

public class Instructor extends Person {
    private ArrayList<String> courses;

    public Instructor(String personID, String personName) {
        super(personID, personName);
        this.courses = new ArrayList<>();
    }

    @Override
    public void mainTask() {
        System.out.println("Teaches");
    }
}