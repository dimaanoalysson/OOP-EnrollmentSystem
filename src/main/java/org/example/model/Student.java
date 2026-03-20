package org.example.model;

public class Student extends Person {
    private String program;
    private TuitionFeePayment paymentTransaction;

    // No-args Constructor
    public Student(){
        super();
        this.paymentTransaction = new TuitionFeePayment();
    }

    // Constructor
    public Student(String PersonID, String PersonName, String program){
        super(PersonID, PersonName);
        this.program = program;
        this.paymentTransaction = new TuitionFeePayment();
    }

    public void setProgram(String program){
        this.program = program;
    }

    public String getProgram(){
        return program;
    }

    public TuitionFeePayment getPaymentTransaction() {
        return paymentTransaction;
    }

    @Override
    public void mainTask() {
        System.out.println("Studying");
    }
}