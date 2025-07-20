/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myassignment;

import java.util.Scanner;

/**
 *
 * @author AAA
 */
public class MyAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        DictionaryManager manager = new FileDictionaryManager("dictionary.txt") {};
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nTừ điển Ngôn ngữ");
            System.out.println("1. Thêm từ mới");
            System.out.println("2. Tra từ");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng (1-3): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }

            if (choice == 3) {
                System.out.println("Tạm biệt!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhập từ mới: ");
                    String word = scanner.nextLine();
                    System.out.print("Nhập nghĩa của từ: ");
                    String meaning = scanner.nextLine();
                    manager.addWord(word, meaning);
                    System.out.println("Đã thêm từ: " + word);
                    break;
                case 2:
                    System.out.print("Nhập từ cần tra: ");
                    String lookupWord = scanner.nextLine();
                    System.out.println(manager.lookupWord(lookupWord));
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        scanner.close();
    }
    
}
