package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", columnDefinition = "int", nullable = false)
    private int orderId;
    @Column(name = "departure", columnDefinition = "datetime", nullable = false)
    private String departure;
    @Column(name = "addressDeparture", columnDefinition = "nvarchar(100)", nullable = false)
    private int addressDeparture;
    @Column(name = "paymentType", columnDefinition = "nvarchar(100)", nullable = false)
    private int paymentType;
    @Column(name = "orderPrice", columnDefinition = "float", nullable = false)
    private int orderPrice;
    @Column(name = "productCount", columnDefinition = "int", nullable = false)
    private int productCount;

    public Order(int orderId, String departure, int addressDeparture, int paymentType, int orderPrice, int productCount) {
        this.orderId = orderId;
        this.departure = departure;
        this.addressDeparture = addressDeparture;
        this.paymentType = paymentType;
        this.orderPrice = orderPrice;
        this.productCount = productCount;
    }

    public Order() {

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getAddressDeparture() {
        return addressDeparture;
    }

    public void setAddressDeparture(int addressDeparture) {
        this.addressDeparture = addressDeparture;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && addressDeparture == order.addressDeparture && paymentType == order.paymentType && orderPrice == order.orderPrice && productCount == order.productCount && Objects.equals(departure, order.departure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, departure, addressDeparture, paymentType, orderPrice, productCount);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", departure='" + departure + '\'' +
                ", addressDeparture=" + addressDeparture +
                ", paymentType=" + paymentType +
                ", orderPrice=" + orderPrice +
                ", productCount=" + productCount +
                '}';
    }
}
