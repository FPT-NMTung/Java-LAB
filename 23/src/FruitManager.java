
import java.util.ArrayList;
import java.util.Iterator;

public class FruitManager {
    private ArrayList<Fruit> listFruit = new ArrayList<>();
    private int id = 1;
            
    public void addNewFruit (Fruit newFruit) {
        newFruit.setId(id);
        listFruit.add(newFruit);
        
        id ++;
    }
    
    public Fruit searchFruit (int id) {
        for (Iterator<Fruit> iterator = listFruit.iterator(); iterator.hasNext();) {
            Fruit next = iterator.next();
            
            if (next.getId() == id) {
                return next;
            }
        }
        
        return new Fruit();
    }

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }
}
