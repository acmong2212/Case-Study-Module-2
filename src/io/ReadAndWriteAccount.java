package io;

import model.Account;
import model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteAccount {
    public static List<Account> readAccount() {
        try {
            File file = new File("account.txt");
            if (!file.isFile()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream("account.txt");

            if (fis.available() != 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (List<Account>) ois.readObject();
            }
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeAccount(List<Account> accountList) {
        try {
            FileOutputStream fos = new FileOutputStream("account.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accountList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}