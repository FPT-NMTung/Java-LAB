/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0007;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class J1SP0007 {
    public static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int size = inputSize();
        int[][] graph = new int[size][size];
        
        inputElements(graph);
    }
    
    //function return number input by user
    public static int inputSize () {
        int number;
        number = sc.nextInt();
        
        return number;
    }
    
    //function input each element for graph
    public static void inputElements (int[][] graph) {
        
    }
}
