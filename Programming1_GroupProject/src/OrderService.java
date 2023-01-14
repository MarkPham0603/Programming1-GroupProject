import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

class OrderService {
    private List<Order> orders;
    private int orderId;
    private ProductService productService; // an instance of ProductService class to interact with products
    
        public int createOrder(Customer customer, List<Product> products) {
        // calculate total price for the products and create new order
        double totalPrice = 0;
        for(Product product: products) {
            totalPrice += product.getPrice();
        }
        Order order = new Order(++orderId, customer, products, "New", totalPrice, 0);
        orders.add(order);
        return orderId;
    }
    
    public void updateOrder(int orderId, List<Product> productsToAdd, List<Product> productsToRemove) {
        // add or remove products from the order
        Order order = getOrderById(orderId);
        if (order != null) {
            for(Product product: productsToAdd) {
                order.getProducts().add(product);
                order.setTotalPrice(order.getTotalPrice() + product.getPrice());
            }
            for(Product product: productsToRemove) {
                order.getProducts().remove(product);
                order.setTotalPrice(order.getTotalPrice() - product.getPrice());
            }
        }
    }
    
    public double viewOrderPrice(int orderId) {
        // view the total price of all items in the order
        Order order = getOrderById(orderId);
        if (order != null) {
            return order.getTotalPrice();
        }
        return 0;
    }
    
    public Order getOrderById(int orderId) {
        // helper method to retrieve an order by its id
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
     public void approveOrder(int orderId) {
        // change the status of an order to "delivered"
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus("Delivered");
        }
    }

    public void viewOrderStatus(int orderId) {
        // view the status of an order
        Order order = getOrderById(orderId);
        if (order != null) {
            System.out.println("Order Status: " + order.getStatus());
        }
    }
    
    public void viewAllOrders() {
        // view all the orders
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Customer: " + order.getCustomer().getName());
            System.out.println("Products: " + order.getProducts());
            System.out.println("Total Price: " + order.getTotalPrice());
            System.out.println("Discount: " + order.getDiscount());
            System.out.println("Status: " + order.getStatus());
        }
    }
        public void sortProductsByName(Order order) {
        Collections.sort(order.getProducts(), new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getTitle().compareTo(p2.getTitle());
            }
        });
    }
}
