package view;

import controller.ControllerStaff;
import model.StaffFullTime;

import java.util.Scanner;

public class ViewStaff {
    static Scanner scanner = new Scanner(System.in);

    public static void menuManagerAdmin() {
        System.out.println("1. Sửa Account" + "\n"
                + "2. Xoá Account" + "\n"
                + "3. Hiển thị Account" + "\n"
                + "4. Đăng xuất");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
        }
    }

    public static void menuManagerStaff() {
        ControllerStaff controllerStaff = new ControllerStaff();

        while (true) {
            System.out.println("-----Quản lý nhân viên-----" + "\n"
                    + "1. Hiển thị nhân viên" + "\n"
                    + "2. Thêm nhân viên" + "\n"
                    + "3. Sửa nhân viên" + "\n"
                    + "4. Xoá nhân viên" + "\n"
                    + "5. Tìm kiếm nhân viên" + "\n"
                    + "6. Kiểm tra trạng thái của nhân viên" + "\n"
                    + "7. Thay đổi trạng thái của nhân viên" + "\n"
                    + "8. Tính tiền lương của nhân viên" + "\n"
                    + "9. Phân loại nhân viên" + "\n"
                    + "0. Thoát");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    controllerStaff.displayStaff();
                    break;
                case 2:
                    System.out.println("Bạn muốn thêm?" + "\n"
                            + "1. Thêm nhân viên Full Time" + "\n"
                            + "2. Thêm nhân viên Part Time ");
                    int choiceAdd = scanner.nextInt();
                    switch (choiceAdd) {
                        case 1:
                            controllerStaff.add(controllerStaff.addStaff(true));
                            break;
                        case 2:
                            controllerStaff.add(controllerStaff.addStaff(false));
                            break;
                    }
                    break;
                case 3:
                    int index = controllerStaff.findIndex();

                    if (index != -1) {
                        if (controllerStaff.findAll().get(index) instanceof StaffFullTime) {
                            controllerStaff.edit(index, controllerStaff.updateStaff(true, index));
                        } else {
                            controllerStaff.edit(index, controllerStaff.updateStaff(false, index));
                        }
                    }
                    break;
                case 4:
                    controllerStaff.deleteStaff();
                    break;
                case 5:
                    controllerStaff.searchStaff();
                    break;
                case 6:
                    controllerStaff.checkStatus();
                    break;
                case 7:
                    controllerStaff.updateStatus();
                    break;
                case 8:
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}