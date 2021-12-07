package view;

import controller.ControllerAccount;
import model.Account;

import java.util.Scanner;

public class ViewAccount {
    public static void menuSignInAndSignUp() {
        Scanner scanner = new Scanner(System.in);
        ControllerAccount controllerAccount = new ControllerAccount();

        while (true) {
            System.out.println(" ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁");
            System.out.println(" ❁                                      ❁");
            System.out.println(" ❁           1. Đăng nhập               ❁");
            System.out.println(" ❁                 hay                  ❁");
            System.out.println(" ❁           2. Đăng ký                 ❁");
            System.out.println(" ❁                                      ❁");
            System.out.println(" ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁ ❁");
            System.out.println("Bạn định làm gì tôi? ᕦ(ò_óˇ)ᕤ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2) {
                    System.err.println("Bạn chỉ có thể lựa chọn 1 hoặc 2");
                    menuSignInAndSignUp();
                }
            } catch (Exception e) {
                System.err.println("Nhập số cơ mà");
            }
            switch (choice) {
                case 1:
                    Account account = controllerAccount.signInAdmin();
                    if (controllerAccount.loginAdmin(account)) {
                        ViewStaff.menuManagerAdmin();
                        break;
                    } else if (controllerAccount.signIn(account)) {
                        ViewStaff.menuManagerStaff();
                        break;
                    } else {
                        System.err.println("Tài khoản hoặc mật khẩu không đúng. Nhập lại xem nào");
                        menuSignInAndSignUp();
                    }
                case 2:
                    controllerAccount.addAccount(controllerAccount.signUpAccount());
                    System.out.println("ĐÃ ĐĂNG KÝ!!!");
                    break;
            }
        }
    }
}
