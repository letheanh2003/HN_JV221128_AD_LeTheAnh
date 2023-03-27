package Exam_Advance_2;

import java.util.*;

public class ReverseWordsInSentence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU****************");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            System.out.print("Vui lòng nhập lựa chọn của bạn: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập câu: ");
                    String sentence = input.nextLine();
                    String[] words = sentence.split("\\s+");
                    for (String word : words) {
                        stack.push(word);
                    }
                    break;
                case 2:
                    System.out.print("Câu đảo ngược: ");
                    while (!stack.empty()) {
                        System.out.print(stack.pop() + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
                    break;
            }
        }
    }
}