package shopInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Main class

        private static List<Invoice> invoices = new ArrayList<>();
        private static List<Product> products = new ArrayList<>();

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                Menu.show();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Handle Shop Settings
                        handleShopSettings(scanner);
                        break;
                    case 2:
                        // Handle Manage Shop Items
                        handleManageShopItems(scanner);
                        break;
                    case 3:
                        // Handle Create New Invoice
                        handleCreateNewInvoice(scanner);
                        break;
                    case 4:
                        // Handle Report: Statistics
                        handleReportStatistics();
                        break;
                    case 5:
                        // Handle Report: All Invoices
                        handleReportAllInvoices();
                        break;
                    case 6:
                        // Handle Search Invoices
                        handleSearchInvoices(scanner);
                        break;
                    case 7:
                        // Handle Program Statistics
                        handleProgramStatistics();
                        break;
                    case 8:
                        exit = true;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            }
        }

        private static void handleShopSettings(Scanner scanner) {
            System.out.println("Shop Settings Menu:");
            System.out.println("1. Load Data");
            System.out.println("2. Set Shop Name");
            System.out.println("3. Set Invoice Header");
            System.out.println("4. Go Back");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Implement load data functionality
                    break;
                case 2:
                    // Implement set shop name functionality
                    break;
                case 3:
                    // Implement set invoice header functionality
                    break;
                case 4:
                    // Go back to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        private static void handleManageShopItems(Scanner scanner) {
            System.out.println("Manage Shop Items Menu:");
            System.out.println("1. Add Items");
            System.out.println("2. Delete Items");
            System.out.println("3. Change Item Price");
            System.out.println("4. Report All Items");
            System.out.println("5. Go Back");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Implement add items functionality
                    break;
                case 2:
                    // Implement delete items functionality
                    break;
                case 3:
                    // Implement change item price functionality
                    break;
                case 4:
                    // Implement report all items functionality
                    break;
                case 5:
                    // Go back to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        private static void handleCreateNewInvoice(Scanner scanner) {
            private static void handleCreateNewInvoice(Scanner scanner) {
                System.out.println("Creating New Invoice:");

                System.out.print("Enter Customer Full Name: ");
                String customerFullName = scanner.nextLine();

                System.out.print("Enter Phone Number: ");
                String phoneNumber = scanner.nextLine();

                // Get current date as invoice date
                Date invoiceDate = new Date();

                List<Product> items = new ArrayList<>();
                boolean addMoreItems = true;

                while (addMoreItems) {
                    System.out.print("Enter Item ID: ");
                    String itemId = scanner.nextLine();

                    System.out.print("Enter Item Name: ");
                    String itemName = scanner.nextLine();

                    System.out.print("Enter Unit Price: ");
                    double unitPrice = scanner.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    // Create new product
                    Product newItem = new Product(itemId, itemName, unitPrice, quantity);
                    items.add(newItem);

                    System.out.print("Add another item? (yes/no): ");
                    String addAnotherItem = scanner.next();
                    addMoreItems = addAnotherItem.equalsIgnoreCase("yes");
                    scanner.nextLine(); // Consume newline character after nextInt()
                }

                // Calculate total amount
                double totalAmount = 0.0;
                for (Product item : items) {
                    totalAmount += item.getUnitPrice() * item.getQuantity();
                }

                // Initialize paid amount as 0 and calculate balance
                double paidAmount = 0.0;
                double balance = totalAmount - paidAmount;

                // Create new invoice
                Invoice newInvoice = new Invoice(customerFullName, phoneNumber, invoiceDate, items, totalAmount, paidAmount, balance);
                invoices.add(newInvoice);

                System.out.println("Invoice created successfully!");
            }

            }

        private static void handleReportStatistics() {
            // Implement report statistics functionality
        }

        private static void handleReportAllInvoices() {
            // Implement report all invoices functionality
        }

        private static void handleSearchInvoices(Scanner scanner) {
            // Implement search invoices functionality
        }

        private static void handleProgramStatistics() {
            // Implement program statistics functionality
        }
    }

