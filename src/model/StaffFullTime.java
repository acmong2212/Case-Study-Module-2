package model;

public class StaffFullTime extends Staff {
    private int workingTime;

    public StaffFullTime(int id, String name, int age, String address, boolean status, int workingTime) {
        super(id, name, age, address, status);
        this.workingTime = workingTime;
    }

    public double getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    @Override
    public String toString() {
        return "Staff FullTime{" + super.toString() +
                "workingTime= " + workingTime +
                '}';
    }
}
