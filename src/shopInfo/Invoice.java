package shopInfo;

import java.util.Date;
import java.util.List;

   public class Invoice {
        private String customerFullName;
        private String phoneNumber;
        private Date invoiceDate;
        private List<Product> items;
        private double totalAmount;
        private double paidAmount;
        private double balance;

        public Invoice(String customerFullName, String phoneNumber, Date invoiceDate, List<Product> items,
                       double totalAmount, double paidAmount, double balance) {
            this.customerFullName = customerFullName;
            this.phoneNumber = phoneNumber;
            this.invoiceDate = invoiceDate;
            this.items = items;
            this.totalAmount = totalAmount;
            this.paidAmount = paidAmount;
            this.balance = balance;
        }

        // Getters and setters
    }


