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
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ                                                                                                  ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ                                            BẠN LÀ ADMIN  ヾ(⌐■_■)ノ♪                              ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ                                                                                                  ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ                                      1. Sửa Account                                              ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ                                      2. Xoá Account                                              ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ                                      3. Hiển thị Account                                         ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ                                      4. Đăng xuất                                                ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ                                                                                                  ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ᓚᘏᗢ ");
            System.out.println("Chọn 1 hành động: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                    System.err.println("Bạn chỉ có thể lựa chọn 1 đến 4");
                    return menuManagerAdmin();
                }
            } catch (Exception e) {
                System.err.println("Nhập số cơ mà");
                return menuManagerAdmin();
            }
            switch (choice) {
                case 1:
                    System.out.println("Bạn muốn sửa Account nào?: ");
                    int index = controllerAccount.findIndexAccount();
                    if (index > -1) {
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
                    System.out.println("( ﾟдﾟ)つ Bye!!");
                    ViewAccount.menuSignInAndSignUp();
                    break;
            }
        }
    }

    public static int menuManagerStaff() {
        ControllerStaff controllerStaff = new ControllerStaff();

        while (true) {
            System.out.println("† † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † ");
            System.out.println("† † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † ");
            System.out.println("† †                                                                                           † † ");
            System.out.println("† †                                 QUẢN LÝ NHÂN VIÊN  ヽ(✿ﾟ▽ﾟ)ノ                              † † ");
            System.out.println("† †                                                                                           † † ");
            System.out.println("† †                             1. Hiển thị nhân viên                                         † † ");
            System.out.println("† †                             2. Thêm nhân viên                                             † † ");
            System.out.println("† †                             3. Sửa nhân viên                                              † † ");
            System.out.println("† †                             4. Xoá nhân viên                                              † † ");
            System.out.println("† †                             5. Tìm kiếm nhân viên                                         † † ");
            System.out.println("† †                             6. Kiểm tra trạng thái làm việc của nhân viên                 † † ");
            System.out.println("† †                             7. Thay đổi trạng thái làm việc của nhân viên                 † † ");
            System.out.println("† †                             8. Tính tiền lương của nhân viên                              † † ");
            System.out.println("† †                             9. Phân loại nhân viên                                        † † ");
            System.out.println("† †                             10. Hiển thị tương đối nhân viên                              † † ");
            System.out.println("† †                             0. Đăng xuất                                                  † † ");
            System.out.println("† †                                                                                           † † ");
            System.out.println("† † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † ");
            System.out.println("† † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † † ");
            System.out.println("Hãy nhập gì đó: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8 && choice != 9 && choice != 10 && choice != 0) {
                    System.err.println("Bạn chỉ có thể lựa chọn 0 đến 10");
                    return menuManagerStaff();
                }
            } catch (Exception e) {
                System.err.println("Mắc gì nhập chữ?");
                return menuManagerStaff();
            }
            switch (choice) {
                case 1:
                    controllerStaff.displayStaff();
                    break;
                case 2:
                    System.out.println(" ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿");
                    System.out.println(" ✿                                                   ✿");
                    System.out.println(" ✿                  Bạn muốn thêm?                   ✿");
                    System.out.println(" ✿                                                   ✿");
                    System.out.println(" ✿          1. Nhân viên Full Time                   ✿");
                    System.out.println(" ✿          2. Nhân viên Part Time                   ✿");
                    System.out.println(" ✿          3. Quay lại màn hình chính               ✿");
                    System.out.println(" ✿          4. Đăng xuất                             ✿");
                    System.out.println(" ✿                                                   ✿");
                    System.out.println(" ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿");
                    System.out.println("Bạn định làm gì tôi? ᕦ(ò_óˇ)ᕤ");
                    int choiceAdd = 0;
                    try {
                        choiceAdd = Integer.parseInt(scanner.nextLine());
                        if (choiceAdd != 1 && choiceAdd != 2 && choiceAdd != 3 && choiceAdd != 4) {
                            System.err.println("Bạn chỉ có thể lựa chọn từ 1 đến 4! Chọn lại đi nhé");
                        }
                    } catch (Exception e) {
                        System.err.println("Mắc gì nhập chữ? Chọn lại đi nhé");
                    }
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
                    } else {
                        System.err.println("Nhân viên này không có trong công ty!!");
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
                    System.out.println("( ﾟдﾟ)つ Bye!!");
                    ViewAccount.menuSignInAndSignUp();
                    break;
            }
        }
    }
}