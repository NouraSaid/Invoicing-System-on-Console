package shopInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InvoiceSystem {
    public static List<Invoice> invoices = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    static ShopSetting shop=new ShopSetting("new shop");
    private static Scanner scanner;
    private String invoiceHeader;

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
                    handleManageShopItems(scanner);
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
                shop.loadData();
                break;
            case 2:
                System.out.print("Enter new shop name: ");
                String newName = scanner.nextLine();
                System.out.println(STR."Shop name set to: \{newName}");
                break;
            case 3:
                shop.setInvoiceHeader();
                break;
            case 4:
                boolean backToMain = true;
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }
    //*********** SHOP Settings Menu Functions ******************

//****************************************************************************************************
    private static void handleManageShopItems(Scanner scanner) {
        boolean exitManageItems = false;
        while (!exitManageItems) {
            System.out.println("\nManage Shop Items Menu:");
            System.out.println("1. Add Items");
            System.out.println("2. Delete Items");
            System.out.println("3. Change Item Price");
            System.out.println("4. Report All Items");
            System.out.println("5. Go Back");
            System.out.print("Choose an option: ");

            int choice = Menu.getNumericOption(scanner);
            switch (choice) {
                case 1:
                    shop.addItems();
                    break;
                case 2:
                    // Implement functionality to delete items
                    break;
                case 3:
                    // Implement functionality to change item price
                    break;
                case 4:
                    // Implement functionality to report all items
                    break;
                case 5:
                    exitManageItems = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
                    break;
            }
        }
    }

    //*********** Main Menu Functions ******************

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
