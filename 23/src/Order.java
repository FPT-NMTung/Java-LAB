
import java.util.ArrayList;

public class Order {
    private String name;
    private ArrayList<Fruit> listFruit;
    private int total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }

    public void setListFruit(ArrayList<Fruit> listFruit) {
        this.listFruit = listFruit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
