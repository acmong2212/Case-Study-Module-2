package io;

import model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteStaff {
    public static List<Staff> readStaff() {
        try {
            File file = new File("staff.txt");
            if (!file.isFile()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream("staff.txt");

            if (fis.available() != 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (List<Staff>) ois.readObject();
            }
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeStaff(List<Staff> staffList) {
        try {
            FileOutputStream fos = new FileOutputStream("staff.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(staffList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}