package model;

public class StaffPartTime extends Staff {
    private int workingTime;

    public StaffPartTime(int id, String name, int age, String address, boolean status, int workingTime) {
        super(id, name, age, address, status);
        this.workingTime = workingTime;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    @Override
    public String toString() {
        return "Staff PartTime{" + super.toString() +
                "workingTime= " + workingTime +
                '}';
    }
}
