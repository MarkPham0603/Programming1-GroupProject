import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderID;
    private Customer customer;
    private List<Product> products;
    private Date orderDate;
    private double totalPrice;
    private String status;

    public Order(String orderID, Customer customer) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.orderDate = new Date();
        this.status = "Pending";
    }

    public String getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        totalPrice -= product.getPrice();
    }
}
