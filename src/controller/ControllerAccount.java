package controller;

import io.ReadAndWriteAccount;
import io.ReadAndWriteStaff;
import model.Account;
import model.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ControllerAccount {
    Scanner scanner = new Scanner(System.in);
    List<Account> accountList = new ArrayList<>();

    public ControllerAccount() {
        accountList = ReadAndWriteAccount.readAccount();
    }

    public Account signUpAccount() {
        String userName;
        while (true) {
            System.out.println("Nhập UserName:");
            userName = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
            if (pattern.matcher(userName).find()) {
                break;
            } else {
                System.err.println("Tên đăng nhập phải là chữ hoặc số!");
            }
        }

        String passWord;
        while (true) {
            System.out.println("Nhập PassWord:");
            passWord = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-z0-9A-Z]{3}+$");
            if (pattern.matcher(passWord).find()) {
                break;
            } else {
                System.err.println("Mật khẩu phải ít nhất 3 kí tự bao gồm chữ hoặc số hoặc chữ cái viết hoa");
            }
        }
        return new Account(userName, passWord);
    }

    public Account signInAdmin() {
        System.out.println("Nhập UserName: ");
        String userName = scanner.nextLine();
        System.out.println("Nhập PassWord: ");
        String passWord = scanner.nextLine();
        return new Account(userName, passWord);
    }

    public void addAccount(Account account) {
        for (Account acc : accountList) {
            if (acc.getUserName().equals(account.getUserName())) {
                return;
            }
        }
        accountList.add(account);
        ReadAndWriteAccount.writeAccount(accountList);
    }

    public List<Account> findAll() {
        return accountList;
    }

    public boolean signIn(Account account) {
        for (Account acc : accountList) {
            if (acc.getUserName().equals(account.getUserName()) && acc.getPassWord().equals(account.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    public boolean loginAdmin(Account account) {
        if (account.getUserName().equals("admin") && account.getPassWord().equals("admin")) {
            return true;
        }
        return false;
    }

    public void displayAccount() {
        for (Account acc : accountList) {
            System.out.println(acc.toString());
        }
    }

    public int findIndexAccount() {
        String userName = scanner.nextLine();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }//validate

    public int findIndexAccountDelete() {
        String userName = scanner.nextLine();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteAccount() {
        System.out.println("Nhập tên Account bạn muốn xoá: ");
        int index = findIndexAccountDelete();
        if (index >= 0) {
            accountList.remove(index);
            System.out.println("ĐÃ XOÁ ACCOUNT NÀY!!");
        }
        ReadAndWriteAccount.writeAccount(accountList);
    }//validate

    public void edit(int index, Account account) {
        accountList.set(index, account);
        ReadAndWriteAccount.writeAccount(accountList);
    }

    public Account updateAccount() {
        System.out.println("Nhập UserName mới:");
        String userName = scanner.nextLine();
        System.out.println("Nhập PassWord mới:");
        String passWord = scanner.nextLine();
        System.out.println("ĐÃ SỬA ACCOUNT NÀY");
        return new Account(userName, passWord);
    }

}

