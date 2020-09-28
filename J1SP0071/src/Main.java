

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    
    public static void main(String[] args){
        int choose = 1;
        int id = 1;
        ArrayList<Task> listTask = new ArrayList<Task>();
        Scanner sc = new Scanner(System.in);
        
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
                    task.inputValue(id);
                    listTask.add(task);
                    id ++;
                    break;
                case 2:
                    
                    break;
                case 3:
                    infaceTask();
                    for (Task eachTask : listTask) {
                        eachTask.display();
                    }
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
