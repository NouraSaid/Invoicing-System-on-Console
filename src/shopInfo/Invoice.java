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

       public String getCustomerFullName() {
           return customerFullName;
       }

       public void setCustomerFullName(String customerFullName) {
           this.customerFullName = customerFullName;
       }

       public String getPhoneNumber() {
           return phoneNumber;
       }

       public void setPhoneNumber(String phoneNumber) {
           this.phoneNumber = phoneNumber;
       }

       public Date getInvoiceDate() {
           return invoiceDate;
       }

       public void setInvoiceDate(Date invoiceDate) {
           this.invoiceDate = invoiceDate;
       }

       public List<Product> getItems() {
           return items;
       }

       public void setItems(List<Product> items) {
           this.items = items;
       }

       public double getTotalAmount() {
           return totalAmount;
       }

       public void setTotalAmount(double totalAmount) {
           this.totalAmount = totalAmount;
       }

       public double getPaidAmount() {
           return paidAmount;
       }

       public void setPaidAmount(double paidAmount) {
           this.paidAmount = paidAmount;
       }

       public double getBalance() {
           return balance;
       }

       public void setBalance(double balance) {
           this.balance = balance;
       }
   }


