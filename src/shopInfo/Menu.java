package shopInfo;
import java.util.Scanner;

public class Menu  {
    public static void show() {
        System.out.println("Main Menu:");
        System.out.println("1. Shop Settings");
        System.out.println("2. Manage Shop Items");
        System.out.println("3. Create New Invoice");
        System.out.println("4. Report: Statistics");
        System.out.println("5. Report: All Invoices");
        System.out.println("6. Search Invoices");
        System.out.println("7. Program Statistics");
        System.out.println("8. Exit");
        System.out.println("Choose an option: ");
    }
    public static int getNumericOption(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (isInteger(input)) {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 8) {
                    return choice; // Valid choice
                } else {
                    System.out.println("Invalid choice. Please enter a number between above range .");
                    System.out.print("Choose an option: ");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Choose an option: ");
            }
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
