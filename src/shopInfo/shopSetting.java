package shopInfo;

import java.util.Scanner;

public class shopSetting {

    public void reportAllInvoices() {
        System.out.println("All Invoices:");
        Invoice[] invoices;
        for (Invoice invoice : invoices) {
            invoice.printInvoiceDetails();
            System.out.println("-------------------------------------");
        }
    }
}

