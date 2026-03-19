package org.example.model;

public class Student extends Person {
    private String program;
    private TuitionFeePayment paymentTransaction;

    //no-args constructor
    public Student(){
        super();
        this.paymentTransaction = new TuitionFeePayment();
    }

    // Constructor
    public Student(String id, String name, String program){
        super(id, name);
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
}