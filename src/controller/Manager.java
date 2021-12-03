package controller;

import model.Staff;

public interface Manager {
    public void displayStaff();
    public void searchStaff();
    public void checkStatus();
    public void updateStatus();
    public Staff addStaff(boolean isStaffFullTime);
    public Staff updateStaff(boolean isStaffFullTime, int index);
    public void deleteStaff();
    public void payRoll();
    public void employeeClassification();
}
