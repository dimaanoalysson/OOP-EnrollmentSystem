package org.example.model;

public class TuitionFeePayment{
    private double pricePerUnit = 1000.00;
    private double balance;
    private double totalTuition;

    public TuitionFeePayment(){
    }

    public double calculateTuitionFee(int units, double discountRate){
        double Fee = units * pricePerUnit;
        double disocuntAmount = Fee * discountRate;

        this.totalTuition = Fee - disocuntAmount;
        this.balance += this.totalTuition;

        return this.totalTuition;
    }

    public void makePayment(double amount){
        if (amount > 0) {
            this.balance -= amount;
            if (this.balance < 0) {
                this.balance = 0;
            }
        } else {
            System.out.println("Error: Amount must be positive.");
        }
    }

    public void getRemainingBalance(){
        System.out.println("Remaining Balance: " + this.balance);
    }

    public boolean isFull() {
        return this.balance <= 0;
    }

    public double getTotalTuition() {
        return totalTuition;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}

