package controller;

import model.Staff;

import java.util.List;

public interface Manager {
    public void displayStaff();
    public void searchStaff();
    public void checkStatus();
    public Staff addStaff(boolean isStaffFullTime);
    public Staff updateStaff(boolean isStaffFullTime);
    public void deleteStaff();
    public void payRoll();
    public void employeeClassification();
}
