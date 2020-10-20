
import java.util.ArrayList;
import java.util.Iterator;

public class Main {    
    private static FruitManager fm = new FruitManager();   
    
    public static void main(String[] args) {
        OrderManager om = new OrderManager(); 
        Validator vali = new Validator();     
        
        int choice;
        
        do {            
            displayMainMenu();
            choice = vali.inputIntValue("Choice");
            
            switch (choice) {
                case 1:
                    Fruit newFruit = inputValueFruit();
                    fm.addNewFruit(newFruit);
                    displayAllFruit(fm.getListFruit());
                    break;
                case 2:
                    displayAllOrder(om.getListOrder());
                    break;
                case 3:
                    displayAllFruit(fm.getListFruit());
                    Order newOrder = inputValueOrder();
                    om.addNewOrder(newOrder);
                    displayOrder(newOrder);
                    break;
                default:
                    break;
            }
        } while (choice != 4);        
    }
    
    public static void displayMainMenu () {
        System.out.println("\n====== Fruit Shop System ======");
        System.out.println("    1, Create Fruit");
        System.out.println("    2, View Order");
        System.out.println("    3, Shopping (For order)");
        System.out.println("    4, Exit");
    }
    
    public static Fruit inputValueFruit () {
        Validator vali = new Validator();
        Fruit newFruit = new Fruit();
        
        System.out.println("\n----- Fruit Information -----");
        
        newFruit.setName(vali.inputStringValue("Name"));
        newFruit.setOrigin(vali.inputStringValue("Origin"));
        newFruit.setPrice(vali.inputIntValue("Price"));
        
        return newFruit;
    }
    
    public static Order inputValueOrder () {
        Validator vali = new Validator();
        Order newOrder1 = new Order();
        int total = 0;
        char ask;
        
        ArrayList<Fruit> listFruit = fm.getListFruit();
        ArrayList<Fruit> orderFruit = new ArrayList<>();
                
        do {            
            int choice = vali.inputIntValue("Choice");
            for (Iterator<Fruit> iterator = listFruit.iterator(); iterator.hasNext();) {
                Fruit next = iterator.next();
                
                if (next.getId() == choice) {
                    System.out.println("Your choice: " + next.getName());
                    int quantity = vali.inputIntValue("Please input quantity");
                    
                    Fruit newFruit = new Fruit();
                    newFruit.setId(choice);
                    newFruit.setName(next.getName());
                    newFruit.setOrigin(next.getOrigin());
                    newFruit.setPrice(next.getPrice());
                    newFruit.setQuantity(quantity);
                    
                    orderFruit.add(newFruit);
                    
                    total += next.getPrice()*quantity;
                }
            }
            
            ask = vali.inputStringValue("Do you want to order now (Y/N)").charAt(0);
        } while (ask != 'Y' && ask != 'y');
        
        newOrder1.setName(vali.inputStringValue("Name"));        
        newOrder1.setListFruit(orderFruit);
        newOrder1.setTotal(total);
        
        return newOrder1;
    }
    
    public static void displayAllFruit (ArrayList<Fruit> list) {
        System.out.println("\n------ List of Fruit ------");
        
        System.out.printf("%-4s|%-12s|%-12s|%-6s\n"
                , "Item"
                , "Fruit Name"
                , "Origin"
                , "Price");
        for (Iterator<Fruit> iterator = list.iterator(); iterator.hasNext();) {
            Fruit next = iterator.next();
            
            System.out.printf("%-4s|%-12s|%-12s|%-6s\n", next.getId(), next.getName(), next.getOrigin(), next.getPrice() + "$");
        }
    }
    
    public static void displayAllOrder (ArrayList<Order> list) {
        System.out.println("\n------ List of Order ------");
        
        for (Iterator<Order> iterator = list.iterator(); iterator.hasNext();) {
            Order next = iterator.next();
            
            System.out.println("\nCustomer: " + next.getName());
            ArrayList<Fruit> listFruit = next.getListFruit();
            
            System.out.printf("%-12s|%-8s|%-5s|%-6s\n"
                    , "Product"
                    , "Quantity"
                    , "Price"
                    , "Amount");
            for (Iterator<Fruit> iterator1 = listFruit.iterator(); iterator1.hasNext();) {
                Fruit next1 = iterator1.next();
                
                System.out.printf("%-12s|%-8s|%-5s|%-6s\n", 
                        next1.getName(), 
                        next1.getQuantity(), 
                        next1.getPrice() + "$", 
                        next1.getQuantity()*next1.getPrice() + "$");
            }
            
            System.out.println("Total: " + next.getTotal() + "$");
        }
    }

    private static void displayOrder(Order newOrder) {
        ArrayList<Fruit> listFruit = newOrder.getListFruit();
        
        System.out.printf("%-12s|%-8s|%-5s|%-6s\n", "Product", "Quantity", "Price", "Amount");
        for (Iterator<Fruit> iterator = listFruit.iterator(); iterator.hasNext();) {
            Fruit next = iterator.next();

            System.out.printf("%-12s|%-8s|%-5s|%-6s\n", 
                    next.getName(), 
                    next.getQuantity(), 
                    next.getPrice() + "$", 
                    next.getQuantity()*next.getPrice() + "$");
        }

        System.out.println("Total: " + newOrder.getTotal());
    }
}
