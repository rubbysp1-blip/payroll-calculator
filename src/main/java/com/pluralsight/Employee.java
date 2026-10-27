package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee() {
    }

    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay(double hoursWorked, double payRate){
        return hoursWorked * payRate;
    }

    @Override
    public String toString() {
        return "Employee Information\n" +
                "------------------------------\n" +
                "Employee ID: " + employeeId + "\n" +
                "Name: " + name + "\n" +
                "Gross Pay: $" + String.format("%.2f", getGrossPay(hoursWorked, payRate)) + "\n" +
                "------------------------------";
    }

    //@Override
    public String toFullInformation() {
        return "Employee Information\n" +
                "------------------------------\n" +
                "Employee ID: " + employeeId + "\n" +
                "Name: " + name + "\n" +
                "Hours Worked: " + hoursWorked + "\n" +
                "Pay Rate: $" + String.format("%.2f", payRate) + "\n" +
                "------------------------------";
    }
}
