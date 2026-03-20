package org.example.model;

import java.util.ArrayList;

public class Instructor extends Person {
    private String program;
    private ArrayList<String> courses;

    public Instructor(String personID, String personName, String courseProgram) {
        super(personID, personName);
        this.program = courseProgram;
        this.courses = new ArrayList<>();
    }

    @Override
    public void mainTask() {
        System.out.println("Teaches");
    }
}