package view;

import controller.Controller;
import model.StaffFullTime;

import java.util.Scanner;

public class ViewStaff {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Controller controller = new Controller();

        while (true) {
            System.out.println("-----Quản lý nhân viên-----" + "\n"
                    + "1. Hiển thị nhân viên" + "\n"
                    + "2. Thêm nhân viên" + "\n"
                    + "3. Sửa nhân viên" + "\n"
                    + "4. Xoá nhân viên" + "\n"
                    + "5. Tìm kiếm nhân viên" + "\n"
                    + "6. Kiểm tra trạng thái của nhân viên" + "\n"
                    + "7. Tính tiền lương của nhân viên" + "\n"
                    + "8. Phân loại nhân viên" + "\n"
                    + "0. Thoát");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    controller.displayStaff();
                    break;
                case 2:
                    System.out.println("Bạn muốn thêm?" + "\n"
                            + "1. Thêm nhân viên Full Time" + "\n"
                            + "2. Thêm nhân viên Part Time ");
                    int choiceAdd = scanner.nextInt();
                    switch (choiceAdd) {
                        case 1:
                            controller.add(controller.addStaff(true));
                            break;
                        case 2:
                            controller.add(controller.addStaff(false));
                            break;
                    }
                    break;
                case 3:
                    int index = controller.findIndex();
                    if (index != -1) {
                        if (controller.findAll().get(index) instanceof StaffFullTime) {
                            controller.edit(index, controller.updateStaff(true));
                        } else {
                            controller.edit(index, controller.updateStaff(false));
                        }
                    }
                    break;
                case 4:
                    controller.deleteStaff();
                    break;
                case 5:
                    controller.searchStaff();
                    break;
                case 6:
                    controller.checkStatus();
                    break;
                case 7:
                case 8:
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}