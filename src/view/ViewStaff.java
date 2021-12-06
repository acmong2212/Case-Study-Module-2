package view;

import controller.ControllerAccount;
import controller.ControllerStaff;
import model.StaffFullTime;

import java.util.Scanner;

public class ViewStaff {
    static Scanner scanner = new Scanner(System.in);

    public static int menuManagerAdmin() {
        ControllerAccount controllerAccount = new ControllerAccount();

        while (true) {
            System.out.println("1. Sửa Account" + "\n"
                    + "2. Xoá Account" + "\n"
                    + "3. Hiển thị Account" + "\n"
                    + "4. Đăng xuất");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                    System.err.println("Bạn chỉ có thể lựa chọn 1 đến 4");
                    return menuManagerAdmin();
                }
            }catch (Exception e) {
                System.err.println("Nhập số cơ mà");
                return menuManagerAdmin();
            }
            switch (choice) {
                case 1:
                    System.out.println("Bạn muốn sửa Account nào?: ");
                    int index = controllerAccount.findIndexAccount();
                    if(index>-1){
                        controllerAccount.edit(index, controllerAccount.updateAccount());
                    } else {
                        System.err.println("Không có Account này trong danh sách, chọn lại nhé!!");
                    }
                    break;
                case 2:
                    controllerAccount.deleteAccount();
                    break;
                case 3:
                    controllerAccount.displayAccount();
                    break;
                case 4:
                    System.out.println("BYE!!");
                    ViewAccount.menuSignInAndSignUp();
                    break;
            }
        }
    }

    public static int menuManagerStaff() {
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
                    + "10. Hiển thị tương đối nhân viên" + "\n"
                    + "0. Đăng xuất");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8 && choice != 9 && choice != 10 && choice != 0) {
                    System.err.println("Bạn chỉ có thể lựa chọn 0 đến 9");
                    return menuManagerStaff();
                }
            } catch (Exception e){
                System.err.println("Mắc gì nhập chữ? Đăng nhập lại bạn nhé!");
            }
            switch (choice) {
                case 1:
                    controllerStaff.displayStaff();
                    break;
                case 2:
                    System.out.println("Bạn muốn thêm?" + "\n"
                            + "1. Nhân viên Full Time" + "\n"
                            + "2. Nhân viên Part Time " + "\n"
                            + "3. Quay lại màn hình chính" + "\n"
                            + "4. Đăng xuất");
                    int choiceAdd = Integer.parseInt(scanner.nextLine());
                    switch (choiceAdd) {
                        case 1:
                            controllerStaff.add(controllerStaff.addStaff(true));
                            break;
                        case 2:
                            controllerStaff.add(controllerStaff.addStaff(false));
                            break;
                        case 3:
                            menuManagerStaff();
                            break;
                        case 4:
                            ViewAccount.menuSignInAndSignUp();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Bạn muốn sửa nhân viên nào?");
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
                    controllerStaff.payRoll();
                    break;
                case 9:
                    controllerStaff.employeeClassification();
                    break;
                case 10:
                    controllerStaff.relativeDisplayStaff();
                    break;
                case 0:
                    System.out.println("ĐÃ ĐĂNG XUẤT!!");
                    ViewAccount.menuSignInAndSignUp();
                    break;
            }
        }
    }
}