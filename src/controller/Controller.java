package controller;

import io.ReadAndWrite;
import model.Staff;
import model.StaffFullTime;
import model.StaffPartTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements Manager {

    Scanner scanner = new Scanner(System.in);
    private List<Staff> staffList = new ArrayList<>();

    public Controller() {
        staffList = ReadAndWrite.readStaff();
    }

    public void add(Staff staff) {
        staffList.add(staff);
        ReadAndWrite.writeStaff(staffList);
    }

    public void edit(int index, Staff staff) {
        staffList.set(index, staff);
        ReadAndWrite.writeStaff(staffList);
    }

    public List<Staff> findAll() {
        return staffList;
    }

    public int findIndex() {
        System.out.println("Nhập tên cần thao tác: ");
        String name = scanner.nextLine();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void displayStaff() {
        for (Staff s : staffList) {
            System.out.println(s.toString());
        }
    }

    @Override
    public void searchStaff() {
        System.out.println("Nhập tên nhân viên mà bạn muốn tìm: ");
        String name = scanner.nextLine();
        int index = -1;
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (name.contains(staffList.get(i).getName())) {
                check = true;
                index = staffList.indexOf(staffList.get(i));
            }
        }
        if (check) {
            System.out.println(staffList.get(index));
        } else {
            System.err.println("TÊN NÀY KHÔNG CÓ TRONG DANH SÁCH!!!");
        }
    }


    @Override
    public void checkStatus() {
        System.out.println("Bạn muốn kiểm tra trạng thái của ai? Hãy nhập tên người đó: ");
        String name = scanner.nextLine();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().equals(name)) {
                if (staffList.get(i).isStatus()) {
                    System.out.println("Đang làm việc");
                } else {
                    System.out.println("Đã nghỉ");
                }
            }
        }
    }

    @Override
    public Staff addStaff(boolean isStaffFullTime) {
        int id;
        if (staffList.size() == 0) {
            id = 1;
        } else {
            id = staffList.get(staffList.size() - 1).getId() + 1;
        }
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ:");
        String address = scanner.nextLine();
        System.out.println("Nhập trạng thái:");
        boolean status = Boolean.parseBoolean(scanner.nextLine());

        if (isStaffFullTime) {
            System.out.println("Nhập thời gian làm việc full time:");
            int workTime = Integer.parseInt(scanner.nextLine());
            System.out.println("ĐÃ THÊM NHÂN VIÊN NÀY!!!");
            return new StaffFullTime(id, name, age, address, status, workTime);
        } else {
            System.out.println("Nhập thời gian làm việc part time:");
            int workTime = Integer.parseInt(scanner.nextLine());
            System.out.println("ĐÃ THÊM NHÂN VIÊN NÀY!!!");
            return new StaffPartTime(id, name, age, address, status, workTime);
        }
    }

    @Override
    public Staff updateStaff(boolean isStaffFullTime) {
        int id;
        if (staffList.size() == 0) {
            id = 1;
        } else {
            id = staffList.get(staffList.size() - 1).getId() + 1;
        }
        System.out.println("Nhập tên mới của nhân viên này:");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi mới của nhân viên này:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ mới của nhân viên này:");
        String address = scanner.nextLine();
        System.out.println("Nhập trạng thái mới của nhân viên này:");
        boolean status = Boolean.parseBoolean(scanner.nextLine());

        if (isStaffFullTime) {
            System.out.println("Nhập thời gian làm việc full time:");
            int workTime = Integer.parseInt(scanner.nextLine());
            System.out.println("ĐÃ SỬA NHÂN VIÊN NÀY!!!");
            return new StaffFullTime(id, name, age, address, status, workTime);
        } else {
            System.out.println("Nhập thời gian làm việc part time:");
            int workTime = Integer.parseInt(scanner.nextLine());
            System.out.println("ĐÃ SỬA NHÂN VIÊN NÀY!!!");
            return new StaffPartTime(id, name, age, address, status, workTime);
        }
    }


    @Override
    public void deleteStaff() {
        int index = findIndex();
        if (index >= 0) {
            staffList.remove(index);
            System.out.println("ĐÃ XOÁ NHÂN VIÊN NÀY!!");
        }
        ReadAndWrite.writeStaff(staffList);
    }

    @Override
    public void payRoll() {

    }

    @Override
    public void employeeClassification() {

    }
}
