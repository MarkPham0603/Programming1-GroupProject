class OrderService {
    private List<Order> orders;
    private int orderId;
    
    public OrderService() {
        this.orders = new ArrayList<Order>();
        this.orderId = 0;
    }
    
    public void createOrder(Customer customer, List<Product> products) {
        // code to create a new order, calculate the total price and apply discount
    }
    
    public void approveOrder(int orderId) {
        // code to change the status of an order to "delivered"
    }
    
    public void viewOrders(Customer customer) {
        // code to view all orders, or all orders made by a specific customer
    }
    
    public void addProductToOrder(int orderId, int productId) {
        // code to add a product to an existing order
    }
    
    public void deleteProductFromOrder(int orderId, int productId) {
        // code to remove a product from an existing order
    }
    
    public void viewOrderPrice(int orderId) {
        // code to view the total price for all items in an order
    }
}
