package view;

import controller.ControllerAccount;
import model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ViewAccount {
    public static void menuSignInAndSignUp() {
        Scanner scanner = new Scanner(System.in);
        ControllerAccount controllerAccount = new ControllerAccount();
        List<Account> accountList = new ArrayList<>();

        while (true) {
            System.out.println("1. Đăng nhập" + "\n"
                    + "2. Đăng ký");
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
