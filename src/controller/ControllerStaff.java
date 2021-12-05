package controller;

import io.ReadAndWriteStaff;
import model.Staff;
import model.StaffFullTime;
import model.StaffPartTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ControllerStaff implements Manager {

    Scanner scanner = new Scanner(System.in);
    private List<Staff> staffList = new ArrayList<>();

    public ControllerStaff() {
        staffList = ReadAndWriteStaff.readStaff();
    }

    public void add(Staff staff) {
        staffList.add(staff);
        ReadAndWriteStaff.writeStaff(staffList);
    }

    public void edit(int index, Staff staff) {
        staffList.set(index, staff);
        ReadAndWriteStaff.writeStaff(staffList);
    }

    public List<Staff> findAll() {
        return staffList;
    }

    public int findIndex() {
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
            System.err.println("Nhân viên này không có trong danh sách!!!");
            searchStaff();
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
    public void updateStatus() {
        System.out.println("Bạn muốn thay đổi trạng thái của nhân viên nào? Hãy nhập tên người đó: ");
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
            if (staffList.get(index).isStatus()) {
                staffList.get(index).setStatus(false);
            } else {
                staffList.get(index).setStatus(true);
            }
            System.out.println(staffList.get(index));
            ReadAndWriteStaff.writeStaff(staffList);
        } else {
            System.err.println("TÊN NÀY KHÔNG CÓ TRONG DANH SÁCH!!!");
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

        String name;
        while (true) {
            System.out.println("Nhập tên:");
            name = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$");
            if (pattern.matcher(name).find()) {
                break;
            } else {
                System.err.println("Họ và tên không bao gồm số và kí tự đặc biệt");
            }
        }

        System.out.println("Nhập tuổi:");
        int age = Integer.parseInt(scanner.nextLine());
        if (age < 18) {
            System.err.println("Bạn chưa đủ tuổi để đi làm");
            addStaff(true);
        } else if (age > 60) {
            System.err.println("Chú đã tuổi về hưu, đi làm nữa chi chú");
            addStaff(true);
        } else {
            System.err.println("Oh! Tuổi này khá hợp với công việc đấy, nhập tiếp đi");
        }

        String address;
        while (true) {
            System.out.println("Nhập địa chỉ:");
            address = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$");
            if (pattern.matcher(address).find()) {
                break;
            } else {
                System.err.println("Địa chỉ bao không bao gồm số và các ký tự đặc biệt bạn nhé");
            }
        }

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
    }//fix validate

    @Override
    public Staff updateStaff(boolean isStaffFullTime, int index) {
        int id;
        id = staffList.get(index).getId();

        String name;
        while (true) {
            System.out.println("Nhập tên mới của nhân viên này:");
            name = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$");
            if (pattern.matcher(name).find()) {
                break;
            } else {
                System.err.println("Họ và tên không bao gồm số và kí tự đặc biệt");
            }
        }

        System.out.println("Nhập tuổi mới của nhân viên này:");
        int age = Integer.parseInt(scanner.nextLine());
        if (age < 18) {
            System.err.println("Bạn chưa đủ tuổi để đi làm");
            addStaff(true);
        } else if (age > 60) {
            System.err.println("Chú đã tuổi về hưu, đi làm nữa chi chú");
            addStaff(true);
        } else {
            System.err.println("Oh! Tuổi này khá hợp với công việc đấy, nhập tiếp đi");
        }

        String address;
        while (true) {
            System.out.println("Nhập địa chỉ mới của nhân viên này:");
            address = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$");
            if (pattern.matcher(address).find()) {
                break;
            } else {
                System.err.println("Địa chỉ bao không bao gồm số và các ký tự đặc biệt bạn nhé");
            }
        }

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
    }//fix validate

    @Override
    public void deleteStaff() {
        String name ;
        while (true) {
            System.out.println("Bạn muốn xoá ai vậy? ");
            name = scanner.nextLine();
            int index = -1;
            boolean check = false;
            Pattern pattern = Pattern.compile("[^0-9]");
            if (pattern.matcher(name).find()) {
                for (int i = 0; i < staffList.size(); i++) {
                    if (name.contains(staffList.get(i).getName())) {
                        check = true;
                        index = staffList.indexOf(staffList.get(i));
                    }
                }
                if (check) {
                    staffList.remove(index);
                    System.out.println("Đã xoá nhân viên này!!!");
                } else {
                    System.err.println("Nhân viên này không có trong công ty!!!");
                    System.out.println("Rốt cuộc...");
                    deleteStaff();
                }
                break;
            } else {
                System.err.println("Tên người có số hả mại?");
                System.out.println("Rốt cuộc...");
            }
        }
//        System.out.println("Bạn muốn xoá ai vậy?");
//        int index = findIndex();
//        if (index >= 0) {
//            staffList.remove(index);
//            System.out.println("ĐÃ XOÁ NHÂN VIÊN NÀY!!");
//        } else {
//            System.err.println("Không có nhân viên này trong công ty");
//            deleteStaff();
//        }
        ReadAndWriteStaff.writeStaff(staffList);
    }

    @Override
    public void payRoll() {

    }

    @Override
    public void employeeClassification() {

    }
}
