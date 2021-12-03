package controller;

import io.ReadAndWriteAccount;
import model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerAccount {
    Scanner scanner = new Scanner(System.in);
    List<Account> accountList = new ArrayList<>();

    public ControllerAccount() {
        accountList = ReadAndWriteAccount.readAccount();
    }

    public Account signUpAccount () {
        System.out.println("Nhập UserName:");
        String userName = scanner.nextLine();
        System.out.println("Nhập PassWord:");
        String passWord = scanner.nextLine();
        return new Account(userName, passWord);
    }

    public void addAccount(Account account) {
        for (Account acc: accountList) {
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
}
