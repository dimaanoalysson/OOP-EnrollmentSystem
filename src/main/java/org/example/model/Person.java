package org.example.model;

public class Person {
    private String id;
    private String name;

    //no-args
    public Person(){
    }

    public Person(String id, String name){
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}