package shopInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShopSetting implements ShopBhaviorse{
    private String shopName;
    private Map<String, String> invoiceHeader;
    private Scanner scanner;

    public ShopSetting(String newShop) {
        this.shopName = newShop;
        this.invoiceHeader = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void setInvoiceHeader() {
        System.out.println("Set Invoice Header:");
        System.out.print("Enter telephone number: ");
        String telephone = scanner.nextLine();
        invoiceHeader.put("Telephone", telephone);
        System.out.print("Enter fax number: ");
        String fax = scanner.nextLine();
        invoiceHeader.put("Fax", fax);
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        invoiceHeader.put("Email", email);
        System.out.print("Enter website URL: ");
        String website = scanner.nextLine();
        invoiceHeader.put("Website", website);

        System.out.println("Invoice header set successfully.");
    }

    public Map<String, String> getInvoiceHeader() {
        return invoiceHeader;
    }

    @Override

    public void loadData() {
        System.out.println("Loading initial data...");

        // Example: Load initial invoice header information
        invoiceHeader.put("Telephone", "123-456-7890");
        invoiceHeader.put("Fax", "123-456-7891");
        invoiceHeader.put("Email", "shop@example.com");
        invoiceHeader.put("Website", "www.example.com");

        // Example: Load initial products
        Product product1 = new Product("1", "Product 1", 10.99, 100);
        Product product2 = new Product("2", "Product 2", 20.49, 50);
        Product product3 = new Product("3", "Product 3", 5.99, 200);

        // Add the products to the shop's list of products
        InvoiceSystem.products.add(product1);
        InvoiceSystem.products.add(product2);
        InvoiceSystem.products.add(product3);

        System.out.println("Initial data loaded successfully.");
    }

    @Override
    public void setShopName() {

    }


    @Override
    public void addItems()
    {
        System.out.println("Add Items:");

        System.out.print("Enter Item ID: ");
        String itemId = scanner.nextLine();

        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter Unit Price: ");
        double unitPrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        // Create a new Product object
        Product newProduct = new Product(itemId, itemName, unitPrice, quantity);

        // Add the new product to the shop's list of products
        InvoiceSystem.products.add(newProduct);

        System.out.println("Item added successfully.");
    }



   @Override
   public void deleteItems() {
    System.out.println("Delete Items:");

    System.out.print("Enter Item ID or Name to delete: ");
    String itemToDelete = scanner.nextLine();

    boolean itemFound = false;
    for (Product product : InvoiceSystem.products) {
        if (product.getItemId().equalsIgnoreCase(itemToDelete) || product.getItemName().equalsIgnoreCase(itemToDelete)) {
            InvoiceSystem.products.remove(product);
            itemFound = true;
            System.out.println("Item deleted successfully.");
            break; // Exit loop after deleting the first occurrence
        }
    }

    if (!itemFound) {
        System.out.println("Item not found.");
    }
}
    @Override
    public void changePrice() {
        System.out.println("Change Item Price:");

        System.out.print("Enter Item ID or Name: ");
        String itemToChange = scanner.nextLine();

        boolean itemFound = false;
        for (Product product : InvoiceSystem.products) {
            if (product.getItemId().equalsIgnoreCase(itemToChange) || product.getItemName().equalsIgnoreCase(itemToChange)) {
                System.out.print("Enter new price for " + product.getItemName() + ": ");
                double newPrice = Double.parseDouble(scanner.nextLine());
                product.setUnitPrice(newPrice);
                itemFound = true;
                System.out.println("Price updated successfully.");
                break; // Exit loop after updating the first occurrence
            }
        }

        if (!itemFound) {
            System.out.println("Item not found.");
        }
    }

    @Override
    public void reportItems() {
        System.out.println("Report All Items:");

        if (InvoiceSystem.products.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        System.out.println("ID \t Name \t Unit Price \t Quantity");
        for (Product product : InvoiceSystem.products) {
            System.out.println(product.getItemId() + "\t" + product.getItemName() + "\t" + product.getUnitPrice() + "\t\t" + product.getQuantity());
        }
    }
}



