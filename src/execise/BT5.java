package execise;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class BT5 {
    //1.Khai báo mảng chứa các sinh viên: biên toàn cục của lớp BT5, có thể sử dụng trong các phương thức của lớp BT5
    Student[] arrStudents = new Student[1000];//null, null, null,....,null
    //Khai báo chỉ số phần tử nhỏ nhất chưa chứa giá trị sinh viên
    int currentIndex = 0;

    public static void main(String[] args) {
        //2.Khai báo mảng chứa các sinh viên: biến local của phương thức main, và chỉ dùng được trong main
        Scanner scanner = new Scanner(System.in);
        BT5 bt5 = new BT5();
        do {
            System.out.println("*************QUẢN LÝ SINH VIÊN**************");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bt5.displayStudents();
                    break;
                case 2:
                    bt5.createStudent(scanner);
                    break;
                case 3:
                    bt5.updateStudent(scanner);
                    break;
                case 4:
                    bt5.deleteStudent(scanner);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-5");
            }
        } while (true);
    }

    public void displayStudents() {
        for (int i = 0; i < currentIndex; i++) {
            arrStudents[i].displayData();
        }
    }

    public void createStudent(Scanner scanner) {
        //Cho phép thêm mới nhiều sinh viên
        System.out.println("Nhập vào số sinh viên cần nhập thông tin:");
        int numberOfStudent = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudent; i++) {
            //1. Khởi tạo phần tử currentIndex là 1 đối tượng sinh viên
            arrStudents[currentIndex] = new Student();
            //2. Nhập thông tin cho đối tượng sinh viên tại currentIndex
            arrStudents[currentIndex].inputData(scanner);
            //3. Tăng currentIndex lên 1
            currentIndex++;
        }
    }

    public void updateStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần cập nhật:");
        String studentId = scanner.nextLine();
        //1. Kiểm tra studentId có tồn tại trong mảng arrStudents không?
        //- Có thì tiến hành cập nhật thông tin
        //- Không thì không cập nhật thông tin và in ra thông báo: mã sinh viên không tồn tại
        int indexUpdate = getIndexByStudnentId(studentId);
        if (indexUpdate >= 0) {
            //Tồn tại mã sinh viên trong mảng: tên sinh viên, tuổi, giới tính, địa chỉ, số điện thoại
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sinh viên");
                System.out.println("2. Cập nhật tuổi sinh viên");
                System.out.println("3. Cập nhật giới tính sinh viên");
                System.out.println("4. Cập nhật địa chỉ sinh viên");
                System.out.println("5. Cập nhật số điện thoại sinh viên");
                System.out.println("6. Thoát");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập tên sinh viên cần cập nhật");
                        arrStudents[indexUpdate].setStudentName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập tuổi sinh viên cần cập nhật");
                        arrStudents[indexUpdate].setAge(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập giới tính sinh viên cần cập nhật");
                        arrStudents[indexUpdate].setSex(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.println("Nhập địa chỉ sinh viên cần cập nhật");
                        arrStudents[indexUpdate].setAddress(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("Nhập điện thoại sinh viên cần cập nhật");
                        arrStudents[indexUpdate].setPhone(scanner.nextLine());
                        break;
                    case 6:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-6");
                }
            } while (isExit);
        } else {
            System.err.println("Mã sinh viên không tồn tại");
        }
    }

    public int getIndexByStudnentId(String studentId) {
        for (int i = 0; i < currentIndex; i++) {
            if (arrStudents[i].getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần xóa:");
        String studentId = scanner.nextLine();
        ;
        int indexDelete = getIndexByStudnentId(studentId);
        if (indexDelete >= 0) {
            //thực hiện xóa
            for (int i = indexDelete; i < currentIndex; i++) {
                arrStudents[i] = arrStudents[i + 1];
            }
            currentIndex--;
        } else {
            System.err.println("Mã sinh viên không tồn tại, vui lòng nhập lại");
        }
    }
}
