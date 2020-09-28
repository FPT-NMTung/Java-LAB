
import java.text.SimpleDateFormat;
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
public class Task {
    private int ID;
    private String typeTask;
    private String name;
    private Date date;
    private double from;
    private double to;
    private double time;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int ID, String typeTask, String name, Date date, double time, String assignee, String reviewer) {
        this.ID = ID;
        this.typeTask = typeTask;
        this.name = name;
        this.date = date;
        this.time = time;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(String typeTask) {
        this.typeTask = typeTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    public void inputValue (int id) {
        Scanner sc = new Scanner (System.in);
        this.ID = id;
        
        System.out.println("\n------------Add Task---------------");
        
        //input name
        System.out.print("Requirement Name: ");
        this.name = sc.nextLine();
        
        //input Id task type
        boolean flag = true;
        while (flag) {
            try {
                System.out.print("Task Type: ");
                int temp = Integer.parseInt(sc.nextLine());                
                
                switch (temp + 1) {
                    case 1:
                        typeTask = "Code";
                        break;
                    case 2:
                        typeTask = "Test";
                        break;
                    case 3:
                        typeTask = "Design";
                        break;
                    case 4:
                        typeTask = "Review";
                        break;
                }
                
                flag = false;
            } catch (Exception e) {
                System.out.println("    Task Type must from 1 to 4");
                System.out.println(e.getMessage());
            }
        }
        
        //input date
        flag = true;
        while (flag) {
            try {
                System.out.print("Date: ");
                String stnDate = sc.nextLine();
                
                date = new SimpleDateFormat("dd-MM-yyyy").parse(stnDate);
                
                flag = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        //input from
        flag = true;
        while (flag) {
            try {
                System.out.print("From: ");
                from = Double.parseDouble(sc.nextLine());
                flag = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        //input to
        flag = true;
        while (flag) {
            try {
                System.out.print("To: ");
                to = Double.parseDouble(sc.nextLine());    
                flag = false;            
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        time = to - from;
        
        System.out.print("Assignee: ");
        assignee = sc.nextLine();
        
        System.out.print("Reviewer: ");
        reviewer = sc.nextLine();
    }
    
    public void display () {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formatDate = dateFormat.format(date);
        
        System.out.printf("%-6s", ID + "");
        System.out.printf("%-18s", name);
        System.out.printf("%-14s", typeTask);
        System.out.printf("%-12s", formatDate);
        System.out.printf("%-8s", time + "");
        System.out.printf("%-15s", assignee);
        System.out.printf("%-13s", reviewer);
        
        System.out.println("");
    }
    
    
}
