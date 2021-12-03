package view;

import controller.ControllerAccount;
import model.Account;

import java.util.Scanner;

public class ViewAccount {
    public static void menuSignInAndSignUp() {
        Scanner scanner = new Scanner(System.in);
        ControllerAccount controllerAccount = new ControllerAccount();

        while (true) {
            System.out.println("1. Đăng nhập" + "\n"
                    + "2. Đăng ký");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Account account = controllerAccount.signUpAccount();
                    if (controllerAccount.signIn(account)) {
                        ViewStaff.menuManagerStaff();
                        break;
                    }
                    if (controllerAccount.loginAdmin(account)) {
                        ViewStaff.menuManagerAdmin();
                        break;
                    }
                case 2:
                    controllerAccount.addAccount(controllerAccount.signUpAccount());
                    break;
            }
        }
    }





}
