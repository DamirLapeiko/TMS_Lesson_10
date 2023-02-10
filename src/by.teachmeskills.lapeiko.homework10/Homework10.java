package by.teachmeskills.lapeiko.homework10;
import java.util.Scanner;

public class Homework10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What task do you want to see? Enter a number from 1 to 6: ");
        int taskNumber = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        switch (taskNumber) {
            case 1 -> {
                System.out.print("Create a new string: ");
                String str = sc1.nextLine();
                System.out.println(StringUtils.normalizeString(str));
            }
            case 2 -> {
                System.out.print("Write your card numbers: ");
                String str = sc1.nextLine();
                System.out.println(StringUtils.getSecureCardNumber(str));
            }
            case 3 -> {
                System.out.println("Lapeiko Damir");
                System.out.println(StringUtils.initialsOfName("Lapeiko", "Damir",
                        ""));
            }
            case 4 -> {
                System.out.print("Write your passport number: ");
                String str = sc1.nextLine();
                System.out.println("Is your passport number belarusian?");
                System.out.println(StringUtils.isRightNumberOfBelPassport(str));
            }
            case 5 -> {
                System.out.print("Write your password: ");
                String str = sc1.nextLine();
                System.out.println("Is your password reliable?");
                System.out.println(StringUtils.isReliablePassword(str));
            }
            case 6 -> {
                System.out.print("Write your email: ");
                String str = sc1.nextLine();
                System.out.println("Is this line similar to email?");
                System.out.println(StringUtils.isSimilarStringToEmail(str));
            }
            default -> System.out.println("Wrong number of task");
        }
    }
}