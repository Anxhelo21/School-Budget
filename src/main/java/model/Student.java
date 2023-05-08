package model;

public class Student {
    private int id;
    private String name;
    private double feesPaid;

    public Student(int id, String name, double feesPaid) {
        this.id = id;
        this.name = name;
        this.feesPaid = feesPaid;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public void payFees(double amount) {
        double sum = 0;
        sum = feesPaid + amount;
        if (sum>=5000){
            System.out.println("You have exceeded the total fees!");
            System.out.println("Returning overcharge payment: $"+(sum - 5000)+".");
            feesPaid = 5000;
        } else {
            System.out.println("Payment Complete!");
            System.out.println("Fees Outstanding: " +(5000 - sum));
            feesPaid = sum;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nID: " + id + "\nName: " + name + '\'' + "Fees Paid=" + feesPaid;
    }
}