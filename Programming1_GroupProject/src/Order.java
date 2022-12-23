import java.util.Date;

public class Order {
    private String orderID;
    private Date Datecreated;
    private String status;


    public Order(String orderID, Date datecreated, String status) {
        this.orderID = orderID;
        Datecreated = datecreated;
        this.status = status;
    }

    public Order() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getDatecreated() {
        return Datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.Datecreated = datecreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
