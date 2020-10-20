
import java.util.ArrayList;

public class OrderManager {
    private ArrayList<Order> listOrder = new ArrayList<>();

    public void addNewOrder (Order newOrder) {
        listOrder.add(newOrder);
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }
}
