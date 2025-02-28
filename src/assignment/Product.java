package assignment;

public class Product {

    private String productName;
    private String productDesc;
    private double productPrice;

    public Product() {
    }

    ;
    public Product(String productName, String productDesc, double productPrice) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "\nProduct Name: " + productName
                + "\nProduct Description: " + productDesc
                + "\nProduct Price: RM" + String.format("%.2f", productPrice);

    }
}
