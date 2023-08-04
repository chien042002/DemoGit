package BangDanhSach;

import dao.danhsachsvDAO;
import model.danhsachsv;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private danhsachsvDAO dao;
    private Scanner scanner;

    public Menu() {
        dao = danhsachsvDAO.getInstance();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice = 0;

        do {
            System.out.println("------- MENU -------");
            System.out.println("1. Insert student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. View all students");
            System.out.println("5. Search student by name");
            System.out.println("6. Exit");

            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    searchStudentByName();
                    break;
                case 6:
                    System.out.println("thoát khỏi chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ Vui lòng thử lại.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }

    private void insertStudent() {

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.next();


        if (name.matches(".*\\d+.*")) {
            System.out.println("Tên không hợp lệ! Tên không được chứa số.");
            return;
        }

        System.out.print("Nhập tuổi sinh viên: ");
        String ageInput = scanner.next();


        if (!ageInput.matches("\\d+")) {
            System.out.println("Tuổi không hợp lệ! Tuổi phải là một số nguyên dương.");
            return;
        }
        int age = Integer.parseInt(ageInput);

        System.out.print("Nhập địa chỉ sinh viên: ");
        String address = scanner.next();

        System.out.print("Nhập hạnh kiểm sinh viên: ");
        String conduct = scanner.next();


        danhsachsv student = new danhsachsv(name, age, address, conduct);


        if (dao.selectById(student) != null) {
            System.out.println("Sinh viên đã tồn tại! Không thể chèn sinh viên trùng lặp.");
            return;
        }


        int result = dao.insert(student);
        if (result > 0) {
            System.out.println("Sinh viên được chèn thành công!");
        } else {
            System.out.println("Không thể chèn sinh viên.");
        }
    }

    private void updateStudent() {

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.next();


        danhsachsv student = new danhsachsv(name, 0, "", "");

        student = dao.selectById(student);

        if (student != null) {

            System.out.print("Nhập tuổi sinh viên: ");
            int age = scanner.nextInt();
            System.out.print("Nhập địa chỉ sinh viên: ");
            String address = scanner.next();
            System.out.print("Nhập hạnh kiểm sinh viên: ");
            String conduct = scanner.next();


            student.setTuoi(age);
            student.setDiachi(address);
            student.setHanhkiem(conduct);

            int result = dao.update(student);
            if (result > 0) {
                System.out.println("Sinh viên được cập nhật thành công!");
            } else {
                System.out.println("Không cập nhật được sinh viên.");
            }
        } else {
            System.out.println("không tìm thấy sinh viên!");
        }
    }

    private void deleteStudent() {

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.next();


        danhsachsv student = new danhsachsv(name, 0, "", "");

        student = dao.selectById(student);

        if (student != null) {

            int result = dao.delete(student);
            if (result > 0) {
                System.out.println("Sinh viên đã xóa thành công!");
            } else {
                System.out.println("Không xóa được sinh viên.");
            }
        } else {
            System.out.println("không tìm thấy sinh viên!");
        }
    }
    private void deleteStudentnhohon5() {
        ArrayList<danhsachsv> students = dao.selectALL();

        int count = 0;
        for (danhsachsv student : students) {
            if (student.getTuoi() < 5) {
                int result = dao.delete(student);
                if (result > 0) {
                    count++;
                }
            }
        }

        if (count > 0) {
            System.out.println("Đã xóa " + count + " sinh viên có điểm nhỏ hơn 5.");
        } else {
            System.out.println("Không tìm thấy sinh viên nào có điểm nhỏ hơn 5.");
        }
    }

    private void viewAllStudents() {

        ArrayList<danhsachsv> students = dao.selectALL();


        if (!students.isEmpty()) {
            System.out.println("------- STUDENTS -------");
            for (danhsachsv student : students) {
                displayStudentDetails(student);
            }
            System.out.println("------------------------");
        } else {
            System.out.println("Không tìm thấy sinh viên nào!");
        }
    }

    private void displayStudentDetails(danhsachsv student) {
    }

    private void searchStudentByName() {

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.next();


        danhsachsv student = new danhsachsv(name, 0, "", "");
        danhsachsv result = dao.selectById(student);

        if (result != null) {
            System.out.println("sinh viên được tìm thấy: " + result.toString());
        } else {
            System.out.println("không tìm thấy sinh viên.");
        }
}
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }

}