package model;

public class StaffFullTime extends Staff {
    private int workingTimeOnMonth;
    private int salaryOnHour;

    public StaffFullTime(int id, String name, int age, String address, boolean status, boolean isClassify, int workingTimeOnMonth, int salaryOnHour) {
        super(id, name, age, address, status, isClassify);
        this.workingTimeOnMonth = workingTimeOnMonth;
        this.salaryOnHour = salaryOnHour;
    }

    public StaffFullTime(int workingTimeOnMonth, int salaryOnHour) {
        this.workingTimeOnMonth = workingTimeOnMonth;
        this.salaryOnHour = salaryOnHour;
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
        return "Staff FullTime{" + super.toString() +
                "workingTimeOnMonth=" + workingTimeOnMonth +
                ", salaryOnHour=" + salaryOnHour +
                '}';
    }
}
