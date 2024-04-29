package shopInfo;

public interface ShopBhaviorse {
    void loadShopData();
    void setShopName(String newName);
    void setInvoiceHeader(String header);

    void  addItems();
    void deleteItems();
    void changePrice();
    void reportItems();

}
