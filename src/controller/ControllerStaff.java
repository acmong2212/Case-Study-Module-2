package controller;

import io.ReadAndWriteStaff;
import model.Staff;
import model.StaffFullTime;
import model.StaffPartTime;
import view.ViewStaff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ControllerStaff implements Manager {
    Scanner scanner = new Scanner(System.in);
    private List<Staff> staffList = new ArrayList<>();

    public ControllerStaff() {
        staffList = ReadAndWriteStaff.readStaff();
    }

    public void add(Staff staff) {
        staffList.add(staff);
        ReadAndWriteStaff.writeStaff(staffList);
    }

    public void edit(int index, Staff staff) {
        staffList.set(index, staff);
        ReadAndWriteStaff.writeStaff(staffList);
    }

    public List<Staff> findAll() {
        return staffList;
    }

    public int findIndex() {
        String name = scanner.nextLine();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void displayStaff() {
        if (staffList.isEmpty()) {
            System.err.println("Trống!!!");
            int choice = 0;
            boolean check = true;
            while (check) {
                try {
                    System.out.println("");
                    System.out.println("Nhấn 0 để quay lại màn hình chính");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 0) {
                        ViewStaff.menuManagerStaff();
                        check = false;
                    } else {
                        System.err.println("Bảo nhập 0 mà cứ nhập cái gì đâu");
                    }
                } catch (Exception e) {
                    System.err.println("Số 0 là chữ à?");
                }
            }
            return;
        }
        System.out.format("%-7s %-10s %-10s %-10s %-15s %-20s %-40s %-10s\n",
                "ID", "Tên", "Tuổi", "Địa chỉ", "Trạng thái", "Chức vụ", "Thời gian làm việc trong tháng (Giờ)", "Lương theo giờ");
        staffList = ReadAndWriteStaff.readStaff();
        assert staffList != null;
        for (Staff staff : staffList) {
            String[] line = staff.toString().split(",");
            System.out.format("%-7s %-10s %-10s %-10s %-15s %-20s %-40s %-10s\n",
                    line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
        }
        int choice = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("");
                System.out.println("Nhấn 0 để quay lại màn hình chính");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    ViewStaff.menuManagerStaff();
                    check = false;
                } else {
                    System.err.println("Bảo nhập 0 mà cứ nhập cái gì đâu");
                }
            } catch (Exception e) {
                System.err.println("Số 0 là chữ à?");
            }
        }
    }

    @Override
    public void relativeDisplayStaff() {
        System.out.println("Bạn muốn hiển thị những ai?");
        String name = scanner.nextLine();
        for (Staff staff : staffList) {
            if (staff.getName().contains(name)) {
                System.out.format("%-7s %-10s %-10s %-10s %-15s %-20s %-40s %-10s\n",
                        "ID", "Tên", "Tuổi", "Địa chỉ", "Trạng thái", "Chức vụ", "Thời gian làm việc trong tháng (Giờ)", "Lương theo giờ");
                staffList = ReadAndWriteStaff.readStaff();
                assert staffList != null;
                String[] line = staff.toString().split(",");
                System.out.format("%-7s %-10s %-10s %-10s %-15s %-20s %-40s %-10s\n",
                        line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
                System.out.println("");
            }
        }
    }

    @Override
    public void searchStaff() {
        System.out.println("Bạn muốn tìm ai? ");
        String name = scanner.nextLine();
        int index = -1;
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (name.contains(staffList.get(i).getName())) {
                check = true;
                index = staffList.indexOf(staffList.get(i));
            }
        }
        if (check) {
            System.out.format("%-7s %-10s %-10s %-10s %-15s %-20s %-40s %-10s\n",
                    "ID", "Tên", "Tuổi", "Địa chỉ", "Trạng thái", "Chức vụ", "Thời gian làm việc trong tháng (Giờ)", "Lương theo giờ");
            staffList = ReadAndWriteStaff.readStaff();
            assert staffList != null;
            String[] line = staffList.get(index).toString().split(",");
            System.out.format("%-7s %-10s %-10s %-10s %-15s %-20s %-40s %-10s\n",
                    line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
            System.out.println("");
        } else {
            System.err.println("Làm gì có");
            System.out.println("Rốt cuộc...");
            searchStaff();
        }
    }

    @Override
    public void checkStatus() {
        System.out.println("Bạn muốn kiểm tra trạng thái làm việc của ai?");
        String name = scanner.nextLine();
        for (Staff staff : staffList) {
            if (staff.getName().equals(name)) {
                if (staff.isStatus()) {
                    System.out.println("Nhân viên " + "'" + name + "'" + " đang làm việc");
                } else {
                    System.out.println("Nhân viên " + "'" + name + "'" + " đã nghỉ");
                }
                System.out.println("");
            }
        }
    }

    @Override
    public void updateStatus() {
        System.out.println("Bạn muốn thay đổi trạng thái làm việc của nhân viên nào?");
        String name = scanner.nextLine();
        int index = -1;
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (name.contains(staffList.get(i).getName())) {
                check = true;
                index = staffList.indexOf(staffList.get(i));
            }
        }
        if (check) {
            if (staffList.get(index).isStatus()) {
                staffList.get(index).setStatus(false);
            } else {
                staffList.get(index).setStatus(true);
            }
            System.out.format("%-7s %-10s %-10s %-10s %-15s %-20s %-40s %-10s\n",
                    "ID", "Tên", "Tuổi", "Địa chỉ", "Trạng thái", "Chức vụ", "Thời gian làm việc trong tháng (Giờ)", "Lương theo giờ");
            String[] line = staffList.get(index).toString().split(",");
            System.out.format("%-7s %-10s %-10s %-10s %-15s %-20s %-40s %-10s\n",
                    line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
            System.out.println("");
            ReadAndWriteStaff.writeStaff(staffList);
        } else {
            System.err.println("Nhân viên này không có tên trong công ty!!!");
        }
    }

    @Override
    public Staff addStaff(boolean isStaffFullTime) {
        int id;
        if (staffList.size() == 0) {
            id = 1;
        } else {
            id = staffList.get(staffList.size() - 1).getId() + 1;
        }

        String name;
        while (true) {
            System.out.println("Nhập tên:");
            name = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
            if (pattern.matcher(name).find()) {
                break;
            } else {
                System.err.println("Họ và tên không bao gồm số và kí tự đặc biệt");
            }
        }

        int age = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập tuổi:");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 18 && age <= 60) {
                    System.out.println("Tuổi này có vẻ hợp với công việc đấy, nhập tiếp đi");
                    check = false;
                } else if (age < 18) {
                    System.err.println("Bạn chưa đủ tuổi đi làm đâu anh bạn à :>");
                } else {
                    System.err.println("Chú đã tuổi về hưu, đi làm nữa chi chú");
                }
            } catch (Exception e) {
                System.err.println("Tuổi phải là số không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
            }
        }

        String address;
        while (true) {
            System.out.println("Nhập địa chỉ:");
            address = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\"+\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\"+\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
            if (pattern.matcher(address).find()) {
                System.out.println("Ô, ông bạn gần nhà tôi này :))");
                break;
            } else {
                System.err.println("Địa chỉ bao không bao gồm số và các ký tự đặc biệt bạn nhé");
            }
        }

        int workTimeOnMonth = 0;
        boolean checkWorkingOnMonth = true;
        if (isStaffFullTime) {
            while (checkWorkingOnMonth) {
                try {
                    System.out.println("Nhập số giờ làm việc trong tháng full time:");
                    workTimeOnMonth = Integer.parseInt(scanner.nextLine());
                    if (workTimeOnMonth >= 176 && workTimeOnMonth <= 208 ) {
                        checkWorkingOnMonth = false;
                    } else if (workTimeOnMonth < 176) {
                        System.err.println("Thời làm gian full time tối thiểu là 176 giờ/tháng và tối đa là 208 giờ/tháng anh bạn nhé!");
                    } else {
                        System.err.println("Làm vừa vừa thôi, làm nhiều quá tiền đâu mà tiêu cho hết");
                    }
                } catch (Exception e) {
                    System.err.println("Số giờ làm việc trong tháng phải là số không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
                }
            }

            int salaryOnHour = 0;
            boolean checkSalaryOnHour = true;
            while (checkSalaryOnHour) {
                try {
                    System.out.println("Nhập lương theo giờ full time:");
                    salaryOnHour = Integer.parseInt(scanner.nextLine());
                    if (salaryOnHour >= 40000) {
                        checkSalaryOnHour = false;
                    } else {
                        System.err.println("Tiền lương full time tối thiểu là 40.000VNĐ/Giờ anh bạn nhé!");
                    }
                } catch (Exception e) {
                    System.err.println("Tiền lương phải là số không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
                }
            }

            System.out.println("ĐÃ THÊM NHÂN VIÊN NÀY!!!");
            return new StaffFullTime(id, name, age, address, true, true, workTimeOnMonth, salaryOnHour);
        } else {
            while (checkWorkingOnMonth) {
                try {
                    System.out.println("Nhập số giờ làm việc trong tháng part time:");
                    workTimeOnMonth = Integer.parseInt(scanner.nextLine());
                    if (workTimeOnMonth >= 88 && workTimeOnMonth <= 104) {
                        checkWorkingOnMonth = false;
                    } else if (workTimeOnMonth < 88) {
                        System.err.println("Thời làm gian part time tối thiểu là 88 giờ/tháng và tối đa là 104 giờ/tháng anh bạn nhé!");
                    } else {
                        System.err.println("Làm vừa vừa thôi, làm nhiều quá tiền đâu mà tiêu cho hết");
                    }
                } catch (Exception e) {
                    System.err.println("Số giờ làm việc trong tháng phải là số không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
                }
            }

            int salaryOnHour = 0;
            boolean checkSalaryOnHour = true;
            while (checkSalaryOnHour) {
                try {
                    System.out.println("Nhập lương theo giờ part time:");
                    salaryOnHour = Integer.parseInt(scanner.nextLine());
                    if (salaryOnHour >= 30000) {
                        checkSalaryOnHour = false;
                    } else {
                        System.err.println("Tiền lương part time tối thiểu là 30.000VNĐ/Giờ anh bạn nhé!");
                    }
                } catch (Exception e) {
                    System.err.println("Tiền lương phải là số không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
                }
            }

            System.out.println("ĐÃ THÊM NHÂN VIÊN NÀY!!!");
            return new StaffPartTime(id, name, age, address, true, false, workTimeOnMonth, salaryOnHour);
        }
    }

    @Override
    public Staff updateStaff(boolean isStaffFullTime, int index) {
        int id;
        id = staffList.get(index).getId();

        String name;
        while (true) {
            System.out.println("Nhập tên mới của nhân viên này:");
            name = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
            if (pattern.matcher(name).find()) {
                break;
            } else {
                System.err.println("Họ và tên không bao gồm số và kí tự đặc biệt");
            }
        }

        int age = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập tuổi mới của nhân viên này:");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 18 && age <= 60) {
                    System.out.println("Tuổi này có vẻ hợp với công việc đấy, nhập tiếp đi");
                    check = false;
                } else if (age < 18) {
                    System.err.println("Bạn chưa đủ tuổi đi làm đâu anh bạn à :>");
                } else {
                    System.err.println("Chú đã tuổi về hưu, đi làm nữa chi chú");
                }
            } catch (Exception e) {
                System.err.println("Tuổi không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
            }
        }

        String address;
        while (true) {
            System.out.println("Nhập địa chỉ mới của nhân viên này:");
            address = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
            if (pattern.matcher(address).find()) {
                System.out.println("Ô, ông bạn gần nhà tôi này :))");
                break;
            } else {
                System.err.println("Địa chỉ bao không bao gồm số và các ký tự đặc biệt bạn nhé");
            }
        }

        int workTimeOnMonth = 0;
        boolean checkWorkingOnMonth = true;
        if (isStaffFullTime) {
            while (checkWorkingOnMonth) {
                try {
                    System.out.println("Nhập số giờ làm việc trong tháng full time:");
                    workTimeOnMonth = Integer.parseInt(scanner.nextLine());
                    if (workTimeOnMonth >= 176 && workTimeOnMonth <= 208 ) {
                        checkWorkingOnMonth = false;
                    } else if (workTimeOnMonth < 176) {
                        System.err.println("Thời làm gian full time tối thiểu là 176 giờ/tháng và tối đa là 208 giờ/tháng anh bạn nhé!");
                    } else {
                        System.err.println("Làm vừa vừa thôi, làm nhiều quá tiền đâu mà tiêu cho hết");
                    }
                } catch (Exception e) {
                    System.err.println("Số giờ làm việc trong tháng phải là số không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
                }
            }

            int salaryOnHour = 0;
            boolean checkSalaryOnHour = true;
            while (checkSalaryOnHour) {
                try {
                    System.out.println("Nhập lương theo giờ full time:");
                    salaryOnHour = Integer.parseInt(scanner.nextLine());
                    if (salaryOnHour >= 40000) {
                        checkSalaryOnHour = false;
                    } else {
                        System.err.println("Tiền lương full time tối thiểu là 40.000VNĐ/Giờ anh bạn nhé!");
                    }
                } catch (Exception e) {
                    System.err.println("Tiền lương phải là số không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
                }
            }

            System.out.println("ĐÃ SỬA NHÂN VIÊN NÀY!!!");
            System.out.println("");
            return new StaffFullTime(id, name, age, address, true, true, workTimeOnMonth, salaryOnHour);
        } else {
            while (checkWorkingOnMonth) {
                try {
                    System.out.println("Nhập số giờ làm việc trong tháng part time:");
                    workTimeOnMonth = Integer.parseInt(scanner.nextLine());
                    if (workTimeOnMonth >= 88 && workTimeOnMonth <= 104) {
                        checkWorkingOnMonth = false;
                    } else if (workTimeOnMonth < 88) {
                        System.err.println("Thời làm gian part time tối thiểu là 88 giờ/tháng và tối đa là 104 giờ/tháng anh bạn nhé!");
                    } else {
                        System.err.println("Làm vừa vừa thôi, làm nhiều quá tiền đâu mà tiêu cho hết");
                    }
                } catch (Exception e) {
                    System.err.println("Số giờ làm việc trong tháng phải là số không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
                }
            }

            int salaryOnHour = 0;
            boolean checkSalaryOnHour = true;
            while (checkSalaryOnHour) {
                try {
                    System.out.println("Nhập lương theo giờ part time:");
                    salaryOnHour = Integer.parseInt(scanner.nextLine());
                    if (salaryOnHour >= 30000) {
                        checkSalaryOnHour = false;
                    } else {
                        System.err.println("Tiền lương part time tối thiểu là 30.000VNĐ/Giờ anh bạn nhé!");
                    }
                } catch (Exception e) {
                    System.err.println("Tiền lương phải là số không bao gồm chữ và kí tự đặc biệt anh bạn nhé");
                }
            }

            System.out.println("ĐÃ SỬA NHÂN VIÊN NÀY!!!");
            System.out.println("");
            return new StaffPartTime(id, name, age, address, true, false, workTimeOnMonth, salaryOnHour);
        }
    }

    @Override
    public void deleteStaff() {
        String name;
        while (true) {
            System.out.println("Bạn muốn xoá ai vậy? ");
            name = scanner.nextLine();
            int index = -1;
            boolean check = false;
            Pattern pattern = Pattern.compile("[^0-9]");
            if (pattern.matcher(name).find()) {
                for (int i = 0; i < staffList.size(); i++) {
                    if (name.contains(staffList.get(i).getName())) {
                        check = true;
                        index = staffList.indexOf(staffList.get(i));
                    }
                }
                if (check) {
                    staffList.remove(index);
                    System.out.println("Đã xoá nhân viên này!!!");
                    System.out.println("");
                } else {
                    System.err.println("Nhân viên này không có trong công ty!!!");
                    System.out.println("Rốt cuộc...");
                    deleteStaff();
                }
                break;
            } else {
                System.err.println("Tên người có số hả anh bạn?");
                System.out.println("Rốt cuộc...");
            }
        }
        ReadAndWriteStaff.writeStaff(staffList);
    }

    @Override
    public void payRoll() {
        System.out.println("Bạn muốn tính lương của nhân viên nào? ");
        String name = scanner.nextLine();
        for (Staff staff : staffList) {
            if (staff.getName().equals(name)) {
                if (staff.isClassify()) {
                    System.out.println("Lương full time của nhân viên " + "'" + name + "'" + " là " + ((StaffFullTime) staff).getPayRoll() + " VNĐ");
                    int choice = 0;
                    boolean check = true;
                    while (check) {
                        try {
                            System.out.println("");
                            System.out.println("Nhấn 0 để quay lại màn hình chính");
                            choice = Integer.parseInt(scanner.nextLine());
                            if (choice == 0) {
                                ViewStaff.menuManagerStaff();
                                check = false;
                            } else {
                                System.err.println("Bảo nhập 0 mà cứ nhập cái gì đâu");
                            }
                        } catch (Exception e) {
                            System.err.println("Số 0 là chữ à?");
                        }
                    }
                } else {
                    System.out.println("Lương part time của nhân viên " + "'" + name + "'" + " là " + ((StaffPartTime) staff).getPayRoll() + " VNĐ");
                    int choice = 0;
                    boolean check = true;
                    while (check) {
                        try {
                            System.out.println("");
                            System.out.println("Nhấn 0 để quay lại màn hình chính");
                            choice = Integer.parseInt(scanner.nextLine());
                            if (choice == 0) {
                                ViewStaff.menuManagerStaff();
                                check = false;
                            } else {
                                System.err.println("Bảo nhập 0 mà cứ nhập cái gì đâu");
                            }
                        } catch (Exception e) {
                            System.err.println("Số 0 là chữ à?");
                        }
                    }
                }
                return;
            }
        }
    }

    @Override
    public void employeeClassification() {
        System.out.println("Bạn muốn phân loại nhân viên nào??");
        String name = scanner.nextLine();
        boolean check = false;
        for (Staff staff : staffList) {
            if (staff.getName().equals(name) && staff.isClassify()) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Nhân viên " + "'" + name + "'" + " đang làm full time");
            System.out.println("");
        } else {
            System.out.println("Nhân viên " + "'" + name + "'" + " đang làm part time");
            System.out.println("");
        }
    }
}