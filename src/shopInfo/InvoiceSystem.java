package shopInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InvoiceSystem {
    public static List<Invoice> invoices = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            Menu.show();
            int choice = Menu.getNumericOption(scanner);


            switch (choice) {
                case 1:
                    handleShopSettings(scanner);
                    break;
                case 2:
                    handleManageShopItems();
                    break;
                case 3:
                    handleCreateNewInvoice(scanner);
                    break;
                case 4:
                    handleReportStatistics();
                    break;
                case 5:
                    handleReportAllInvoices();
                    break;
                case 6:
                    handleSearchInvoices(scanner);
                    break;
                case 7:
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
        int choice = Menu.getNumericOption(scanner);
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

    private static void handleManageShopItems() {
        // Implement manage shop items functionality
    }

    private static void handleCreateNewInvoice(Scanner scanner) {
        scanner.nextLine(); // Consume newline character
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
            scanner.nextLine(); // Consume newline character after nextInt()
            String addAnotherItem = scanner.nextLine();
            addMoreItems = addAnotherItem.equalsIgnoreCase("yes");
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

    private static void handleReportAllInvoices() {
        for (Invoice invoice : invoices) {
            System.out.println(invoice); // Assuming Invoice class has a proper toString() method
        }
    }
    private static void handleReportStatistics() {
        // Calculate and display statistics

        // Example statistics to calculate:
        // 1. Total number of invoices
        int totalInvoices = invoices.size();
        System.out.println("Total number of invoices: " + totalInvoices);

        // 2. Total amount of sales
        double totalSales = 0.0;
        for (Invoice invoice : invoices) {
            totalSales += invoice.getTotalAmount();
        }
        System.out.println("Total amount of sales: " + totalSales);

        // 3. Average amount per invoice
        double averageAmountPerInvoice = totalSales / totalInvoices;
        System.out.println("Average amount per invoice: " + averageAmountPerInvoice);

        // 4. Other statistics as needed...

        // You can add more statistics based on your specific requirements
    }


        private static void  handleSearchInvoices(Scanner scanner) {
            System.out.print("Enter customer name to search: ");
            String searchTerm = scanner.nextLine().trim().toLowerCase();

            boolean found = false;
            for (Invoice invoice : invoices) {
                if (invoice.getCustomerFullName().toLowerCase().contains(searchTerm)) {
                    System.out.println(invoice);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No invoices found for the provided customer name.");
            }
        }



        private static void handleProgramStatistics() {
            // Calculate and display program statistics

            // Example statistics to calculate:
            // 1. Total number of invoices
            int totalInvoices = invoices.size();
            System.out.println("Total number of invoices: " + totalInvoices);

            // 2. Total amount of sales
            double totalSales = 0.0;
            for (Invoice invoice : invoices) {
                totalSales += invoice.getTotalAmount();
            }
            System.out.println("Total amount of sales: " + totalSales);

            // 3. Average amount per invoice
            double averageAmountPerInvoice = totalSales / totalInvoices;
            System.out.println("Average amount per invoice: " + averageAmountPerInvoice);

            // 4. Other statistics as needed...

        }
    }
