package BangMonHoc;

import dao.monhocDAO;
import model.monhoc;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static monhocDAO dao = monhocDAO.getInstance();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("1. Insert a subject");
            System.out.println("2. Update a subject");
            System.out.println("3. Delete a subject");
            System.out.println("4. Display all subjects");
            System.out.println("5. Search for a subject by history");
            System.out.println("0. Exit");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    insertSubject();
                    break;
                case 2:
                    updateSubject();
                    break;
                case 3:
                    deleteSubject();
                    break;
                case 4:
                    displayAllSubjects();
                    break;
                case 5:
                    searchByHistory();
                    break;
                case 0:
                    System.out.println("Thoát...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }

    private static void insertSubject() {
        System.out.print("Nhập tên môn tiếng Anh: ");
        String tienganh = scanner.nextLine();

        System.out.print("Nhập tên môn Ngữ Văn: ");
        String nguvan = scanner.nextLine();

        System.out.print("Nhập tên môn Toán: ");
        String toanhoc = scanner.nextLine();

        System.out.print("Nhập tên môn Lịch sử: ");
        String lichsu = scanner.nextLine();

        monhoc subject = new monhoc(tienganh, nguvan, toanhoc, lichsu);
        int result = dao.insert(subject);

        if (result > 0) {
            System.out.println("Đã chèn chủ đề thành công.");
        } else {
            System.out.println("Không thể chèn chủ đề.");
        }
    }

    private static void updateSubject() {
        System.out.print("Nhập tên môn Tiếng Anh của môn cần cập nhật: ");
        String tienganh = scanner.nextLine();

        System.out.print("Nhập tên môn Ngữ Văn đã cập nhật: ");
        String nguvan = scanner.nextLine();

        System.out.print("Nhập tên môn Toán đã cập nhật: ");
        String toanhoc = scanner.nextLine();

        System.out.print("Nhập tên môn Lịch sử đã cập nhật: ");
        String lichsu = scanner.nextLine();

        monhoc subject = new monhoc(tienganh, nguvan, toanhoc, lichsu);
        int result = dao.update(subject);

        if (result > 0) {
            System.out.println("Đã cập nhật chủ đề thành công.");
        } else {
            System.out.println("Không thể cập nhật chủ đề.");
        }
    }

    private static void deleteSubject() {
        System.out.print("Nhập tên môn Toán của môn cần xóa: ");
        String toanhoc = scanner.nextLine();

        monhoc subject = new monhoc(null, null, toanhoc, null);
        int result = dao.delete(subject);

        if (result > 0) {
            System.out.println("Đã xóa chủ đề thành công.");
        } else {
            System.out.println("Không thể xóa chủ đề.");
        }
    }

    private static void displayAllSubjects() {
        ArrayList<monhoc> subjects = dao.selectALL();

        System.out.println("Đối tượng:");
        for (monhoc subject : subjects) {
            System.out.println(subject.getTienganh() + ", " + subject.getNguvan() +
                    ", " + subject.getToanhoc() + ", " + subject.getLichsu());
        }
    }

    private static void searchByHistory() {
        System.out.print("Nhập từ khóa lịch sử để tìm kiếm: ");
        String lichsu = scanner.nextLine();

        monhoc subject = new monhoc(null, null, null, lichsu);
        monhoc result = dao.selectById(subject);

        if (result != null) {
            System.out.println("chủ đề được tìm thấy: " + result.getTienganh() + ", " +
                    result.getNguvan() + ", " + result.getToanhoc() + ", " +
                    result.getLichsu());
        } else {
            System.out.println("Không tìm thấy chủ đề nào với từ khóa lịch sử đã cho.");
        }
    }
}
