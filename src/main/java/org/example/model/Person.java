package org.example.model;

public abstract class Person {
    private String PersonID;
    private String PersonName;

    //no-args
    public Person(){
    }

    public Person(String PersonID, String PersonName){
        this.PersonName = PersonName;
        this.PersonID = PersonID;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        this.PersonID = PersonID;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setName(String personName) {
        this.PersonName = personName;
    }

    public abstract void mainTask();
}