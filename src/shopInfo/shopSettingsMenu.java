package shopInfo;

import java.util.Scanner;

public class shopSettingsMenu {
    public static void shopSettingsMenu(Scanner scanner) {
        boolean exitShopSettings = false;
        while (!exitShopSettings) {
            System.out.println("\nShop Settings:");
            System.out.println("1- Load Data (Items and invoices)");
            System.out.println("2- Set Shop Name");
            System.out.println("3- Set Invoice Header (Tel / Fax / Email / Website)");
            System.out.println("4- Go Back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        // Implement Load Data

                        break;
                    case 2:
                        // Implement Set Shop Name
                        break;
                    case 3:
                        // Implement Set Invoice Header
                        break;
                    case 4:
                        exitShopSettings = true;
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
