import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orderservice extends Order {
    public Orderservice(String orderID, Date datecreated, String status) {
        super(orderID, datecreated, status);
    }

    private List<Order> listofOrder;

    public Orderservice() {
        this.listofOrder = new ArrayList<>();
    }

    public Orderservice(List<Order> listofOrder) {
        this.listofOrder = listofOrder;
    }

    public List<Order> getListofOrder() {
        return listofOrder;
    }

    public int addOrder(Order n) {
        this.listofOrder.add(n);
        return count();
    }

    public int count() {
        return this.listofOrder.size();
    }

    public Order getOrder(int index){
        if(index < 0 || index >= count()){
            return null;
        }
        return this.listofOrder.get(index);
    }

    public boolean removeOrder(String orderID){
        int index = -1;
        for(int i = 0, n= count(); i<n; i++) {
            if(this.listofOrder.get(i).getOrderID() == orderID ){
                index = i;
                break;
            }
        }
        if (index != -1){
            this.listofOrder.remove(index);
            return true;
        }
        return false;
    }
}

