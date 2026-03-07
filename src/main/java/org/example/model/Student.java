package org.example.model;

public class Student extends Person {
    private String program;

    //no-args constructor
    public Student(){
        super();
    }

    // Constructor
    public Student(String id, String name, String program){
        super(id, name);
        this.program = program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    public String getProgram(){
        return program;
    }
}