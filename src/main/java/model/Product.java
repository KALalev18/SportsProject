package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", columnDefinition = "int", nullable = false)
    private int productId;
    @Column(name = "productName", columnDefinition = "nvarchar(100)", nullable = false)
    private String productName;
    @Column(name = "productPrice", columnDefinition = "float", nullable = false)
    private float productPrice;
    @Column(name = "productSize", columnDefinition = "varchar(15)", nullable = false)
    private String productSize;

    public Product(int productId, String productName, float productPrice, String productSize) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSize = productSize;
    }

    public Product() {

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Float.compare(product.productPrice, productPrice) == 0 && Objects.equals(productName, product.productName) && Objects.equals(productSize, product.productSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice, productSize);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productSize='" + productSize + '\'' +
                '}';
    }
}
