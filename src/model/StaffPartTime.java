package model;

import java.text.DecimalFormat;

public class StaffPartTime extends Staff {
    private int workingTimeOnMonth;
    private int salaryOnHour;
    private double payRoll;

    public StaffPartTime(int id, String name, int age, String address, boolean status, boolean isClassify, int workingTimeOnMonth, int salaryOnHour) {
        super(id, name, age, address, status, isClassify);
        this.workingTimeOnMonth = workingTimeOnMonth;
        this.salaryOnHour = salaryOnHour;
        this.payRoll = getPayRoll();
    }

    public StaffPartTime(int workingTimeOnMonth, int salaryOnHour, double payRoll) {
        this.workingTimeOnMonth = workingTimeOnMonth;
        this.salaryOnHour = salaryOnHour;
        this.payRoll = payRoll;
    }

    public StaffPartTime() {
    }

    public double getPayRoll() {
        return payRoll = this.salaryOnHour * this.workingTimeOnMonth;
    }

    public void setPayRoll(double payRoll) {
        this.payRoll = payRoll;
    }

    public int getWorkingTimeOnMonth() {
        return workingTimeOnMonth;
    }

    public void setWorkingTimeOnMonth(int workingTimeOnMonth) {
        this.workingTimeOnMonth = workingTimeOnMonth;
    }

    public int getSalaryOnHour() {
        return salaryOnHour;
    }

    public void setSalaryOnHour(int salaryOnHour) {
        this.salaryOnHour = salaryOnHour;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return "Staff PartTime{" + super.toString() +
                "workingTimeOnMonth= " + workingTimeOnMonth +
                ", salaryOnHour= " +formatter.format(salaryOnHour)+" VNĐ" +
                '}';
    }
}
