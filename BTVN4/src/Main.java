import PK1.Book;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Main {
    public static ArrayList<Book> books = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static void addNewBook() {
        System.out.print("Nhập mã sách: ");
        int maSach = sc.nextInt();
        System.out.print("Nhập tên sách: ");
        String tenSach = sc.nextLine();
        System.out.print("Nhập tên tác giả: ");
        String tenTacGia = sc.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int namSanXuat = sc.nextInt();
        System.out.print("Nhập tóm tắt nội dung: ");
        String tomTatNoiDung = sc.nextLine();
        System.out.print("Nhập giá tiền: ");
        double giaTien = sc.nextDouble();
        Book newBook = new Book(maSach, tenSach, tenTacGia, namSanXuat, tomTatNoiDung, giaTien);
        books.add(newBook);
        System.out.println("Thêm sách thành công");
    }
    public static void editBookInfo() {
        System.out.print("Nhập mã sách để chỉnh sửa: ");
        int maSach = sc.nextInt();
        for (Book book : books) {
            if (book.getMaSach() == maSach) {
                System.out.print("Nhập tên sách mới:");
                book.setTenSach(sc.nextLine());
                System.out.print("Nhập tên tác giả mới:");
                book.setTenTacGia(sc.nextLine());
                System.out.print("Nhập năm sản xuất mới:");
                book.setNamSanXuat(sc.nextInt());
                System.out.print("Nhập tóm tắt nội dung mới:");
                book.setTomTatNoiDung(sc.nextLine());
                System.out.print("Nhập giá tiền mới:");
                book.setGiaTien(sc.nextDouble());
                System.out.println("Chỉnh sửa thông tin thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy mã sách");
    }

    public static void displayOldestBook() {
        Book oldest = Collections.min(books, Comparator.comparingInt(Book::getNamSanXuat));
        System.out.println("Cuốn sách lâu đời nhất:");
        oldest.display();
    }
    public static void findByPrice() {
        System.out.print("Nhập giá tiền: ");
        double price = sc.nextDouble();
        boolean found = false;

        for (Book book : books) {
            if (book.getGiaTien() <= price) {
                book.display();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sách phù hợp với giá tiền yêu cầu.");
    }
    public static void sortBooks() {
        System.out.println("Sắp xếp theo tên ấn: 1");
        System.out.println("Sắp xếp theo giá ấn: 2");
        int option = sc.nextInt();
        if (option == 1) books.sort(Comparator.comparing(Book::getTenSach));
        else books.sort(Comparator.comparingDouble(Book::getGiaTien));
    }

    public static void main(String[] args) {
        books.add(new Book(1, "Book1", "Author1", 2001, "Summary1", 50.0));
        books.add(new Book(2, "Book2", "Author2", 2002, "Summary2", 51.0));
        books.add(new Book(3, "Book3", "Author3", 2003, "Summary3", 52.0));
        books.add(new Book(4, "Book4", "Author4", 2004, "Summary4", 53.0));
        books.add(new Book(5, "Book5", "Author5", 2005, "Summary5", 54.0));

        while (true) {
            System.out.println("\n MENU");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Chỉnh sửa thông tin");
            System.out.println("3. In ra danh sách sách");
            System.out.println("4. In ra quyển sách lâu đời nhất");
            System.out.println("5. In ra những quyển sách phù hợp với giá tiền");
            System.out.println("6. Sắp xếp lại danh sách");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addNewBook();

                case 2 -> editBookInfo();

                case 3 -> {
                    for (Book book : books)
                        book.display();
                }

                case 4 -> displayOldestBook();

                case 5 -> findByPrice();

                case 6 -> sortBooks();
                default -> System.out.println("Không hợp lệ");
            }

        }
    }
}