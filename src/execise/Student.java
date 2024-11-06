package execise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
    //1. Fields/Properties/Attribute: đặc điểm của đối tượng
    //-private datatype fieldName
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private String address;
    private String phone;

    //2. Constructors: hàm tạo để khởi tạo đối tượng
    public Student() {
    }

    public Student(String studentId, String studentName, int age, String address, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    //3. Methods: hành vi của đối tượng
    //3.1. Getter/Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    //3.2. Method Behavior: hành vi
    public void inputData(Scanner scanner) {
        /*
         * Mã sinh viên: Gồm 5 ký tự, 2 ký tự đầu là SV, 3 ký tự sau là số (SV001)
         * Tên sinh viên: Phải gồm từ 6-50 ký tự
         * Tuổi: có giá trị lớn hơn hoặc bằng 18
         * Giới tính: Chỉ nhận giá trị true hoặc false
         * Địa chỉ: không được để trống
         * Số điện thoại: Số điện thoại VN gồm 10 số, bắt đầu là các đầu số: 090, 091, 092, 093, 098, 035
         * */
        this.studentId = inputStudentId(scanner);
        this.studentName = inputStudentName(scanner);
        this.age = inputAge(scanner);
        this.sex = inputSex(scanner);
        this.address = inputAddress(scanner);
        this.phone = inputPhone(scanner);
    }

    public String inputStudentId(Scanner scanner) {
        String studentIdRegex = "SV\\d{3}";
        System.out.println("Nhập vào mã sinh viên:");
        do {
            String studentId = scanner.nextLine();
            if (Pattern.matches(studentIdRegex, studentId)) {
                return studentId;
            }
            System.err.println("Mã sinh viên không đúng định dạng, vui lòng nhập lại");
        } while (true);
    }

    public String inputStudentName(Scanner scanner) {
        System.out.println("Nhập vào tên sinh viên:");
        do {
            String studentName = scanner.nextLine();
            if (studentName.length() >= 6 && studentName.length() <= 50) {
                return studentName;
            }
            System.err.println("Tên sinh viên gồm 6-50 ký tự, vui lòng nhập lại");
        } while (true);
    }

    public int inputAge(Scanner scanner) {
        System.out.println("Nhập vào tuổi sinh viên:");
        do {
            int age = Integer.parseInt(scanner.nextLine());
            if (age >= 18) {
                return age;
            }
            System.err.println("Tuổi sinh viên phải có giá trị lớn hơn hoặc bằng 18, vui lòng nhập lại");
        } while (true);
    }

    public boolean inputSex(Scanner scanner) {
        System.out.println("Nhập vào giới tính của sinh viên:");
        do {
            String sex = scanner.nextLine();
            if (sex.equals("true") || sex.equals("false")) {
                return Boolean.parseBoolean(sex);
            }
            System.err.println("Giới tính sinh viên chỉ nhận giá trị true | false, vui lòng nhập lại");
        } while (true);
    }

    public String inputAddress(Scanner scanner) {
        System.out.println("Nhập vào địa chỉ của sinh viên:");
        do {
            String address = scanner.nextLine();
            if (!address.trim().isEmpty()) {
                return address;
            }
            System.err.println("Địa chỉ sinh viên chưa nhập, vui lòng nhập lại");
        } while (true);
    }

    public String inputPhone(Scanner scanner) {
        String phoneRegex = "(090|091|092|093|098|035)\\d{7}";
        System.out.println("Nhập vào số điện thoại của sinh viên:");
        do {
            String phone = scanner.nextLine();
            if (Pattern.matches(phoneRegex, phone)) {
                return phone;
            }
            System.err.println("Không đúng định dạng số điện thoại ,vui lòng nhập lại");
        } while (true);
    }

    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d - Giới tính: %s\n",
                this.studentId, this.studentName, this.age, this.sex ? "Nam" : "Nữ");
        System.out.printf("Địa chỉ: %s - Số điện thoại: %s\n", this.address, this.phone);
    }
}
