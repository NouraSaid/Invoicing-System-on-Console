package shopInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShopSetting {
    private String shopName;
    private Map<String, String> invoiceHeader;
    private Scanner scanner;

    public ShopSetting(String newShop) {
        this.shopName = newShop;
        this.invoiceHeader = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

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

    public void loadData() {
    }
}
