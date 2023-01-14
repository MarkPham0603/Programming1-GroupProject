class Discount {
    private Map<String, Double> discounts;
    
    public Discount() {
        this.discounts = new HashMap<String, Double>();
        discounts.put("Silver", 0.05);
        discounts.put("Gold", 0.1);
        discounts.put("Platinum", 0.15);
    }
    
    public void calculateDiscount(String membership, double totalPrice) {
        // code to calculate the discount for an order based on the customer's membership level
    }
}
