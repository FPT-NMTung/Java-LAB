

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class MyList {
    ArrayList<Task> listTask;
    int id = 1;
    int idSeach;

    public MyList() {
        listTask = new ArrayList<>();
    }
  
    private void addTask () {
        Task task = new Task();  
        task.inputValue(id);
        listTask.add(task);
        id ++;
        
    }
    
    private void deleteTask () {
        Iterator<Task> itr = listTask.iterator();
        Scanner sc = new Scanner(System.in);
        
        boolean flag = true;
        while (flag) {
            try {        
                System.out.println("------- delete ID -------");
                idSeach = Integer.parseInt(sc.nextLine());
                flag = false;
            } catch (Exception e) {
                System.out.println("    Loi nhap lieu");
            }
        }
        
        while (itr.hasNext()) {
            Task temp = itr.next();
            
            if (temp.getID() == idSeach) {
                listTask.remove(temp);
                break;
            }
        }
    }
    
    private void getDataTasks () {
        infaceTask();
        for (Task eachTask : listTask) {
            eachTask.display();
        }
    }
    
    public static void main(String[] args){
        int choose = 1;
        int id = 1;
        Scanner sc = new Scanner(System.in);
        MyList list = new MyList();
        
        while ((choose >= 1) && (choose <= 3)) {
            mainMenu();
            
            boolean flag = true;
            while (flag) {
                try {                
                    choose = Integer.parseInt(sc.nextLine());
                    flag = false;
                } catch (Exception e) {
                    System.out.println("    Loi nhap lieu");
                }
            }
            
        Task task = new Task();    
            switch (choose) {
                case 1:                    
                    list.addTask();
                    break;
                case 2:
                    list.deleteTask();
                    break;
                case 3:
                    list.getDataTasks();
                    break;
            }
        }    
    }
    
    public static void mainMenu () {
        System.out.println("\n========= Task program =========");
        System.out.println("    1. Add Task");
        System.out.println("    2. Delete task");
        System.out.println("    3. Display Task");
        System.out.println("    4. exit");
        System.out.print("Choose: ");
    }
    
    public static void infaceTask () {
        System.out.println("\n----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-6s", "ID");
        System.out.printf("%-18s", "Name");
        System.out.printf("%-14s", "Task Type");
        System.out.printf("%-12s", "Date");
        System.out.printf("%-8s", "Time");
        System.out.printf("%-15s", "Assignee");
        System.out.printf("%-13s", "Reviewer");
        
        System.out.println("");
    }
}
