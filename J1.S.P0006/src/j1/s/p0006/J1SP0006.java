/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0006;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class J1SP0006 {

    public static void main(String[] args) {
        // TODO code application logic here
        int[] arrayNumber = new int[inputNumberOfArray()];
        int number = inputNumber();
        
        inputElements(arrayNumber);
        System.out.print("Unsorted array: ");
        displayArray(arrayNumber);
        bubbleSort(arrayNumber);        
        System.out.print("Sorted array: ");
        displayArray(arrayNumber);
        search(arrayNumber, number);
    }
    
    //function to search value
    public static void search(int[] array, int number) {
        int begin = 0; 
        int end = array.length;
        int point = (end + begin)/2;
        int location = -1;
        
        while (array[point] != number && begin != end - 1) {
            if (number < array[point]) {
                end = point;
            } else if (number > array[point]) {
                begin = point;
            }
            point = (end + begin)/2;
        }

        if (number == array[point]) {
            location = point;
        }
        
        if (location != -1) {
            System.out.println("Found " + number + " at index " + location);
        } else {
            System.out.println("Not found");
        }
    }
    
    //function use bubble sort to sort array
    public static void bubbleSort(int[] array) {
        int count = array.length - 1;
        while (count > 0) {
            //select element from 0 to count - 1
            for (int index = 0; index < count; index++) {
                //when array[index] > array[index + 1] => swap two elements
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }                
            }
            count--;
        }
    }

    //function to enter each elements with random
    public static void inputElements(int[] array) {
        Random random = new Random();
        //select element from 0 to end array
        for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(array.length);
        }
    }

    //function to user input number of elements and return to main
    public static int inputNumberOfArray() {
        System.out.println("Enter number of array: ");
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        

        return number;
    }

    //display array
    public static void displayArray(int[] array) {
        System.out.print("[");
        //select element from 0 to end array
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index]);
            //dont display "," with last elements
            if (index < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
    
    public static int inputNumber () {
        int number;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter search value:");
        number = sc.nextInt();
        
        return number;
    }
}
