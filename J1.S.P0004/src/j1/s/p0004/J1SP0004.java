/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0004;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class J1SP0004 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arrayNumber = new int[inputNumberOfArray()];

        inputElements(arrayNumber);
        System.out.print("Unsorted array: ");
        displayArray(arrayNumber);
        quicksort(arrayNumber, 0, arrayNumber.length);
        System.out.print("Sorted array: ");
        displayArray(arrayNumber);
    }
    
    // function use quicksort sort to sort array
    public static void quicksort(int[] array, int begin, int end) {
        if (begin < end - 1) {        
            int point = pactition(array, begin, end);
        
            quicksort(array, begin, point);
            quicksort(array, point + 1, end);
        }
    }
    
    //function to sort
    public static int pactition (int[] array, int begin, int end) {
        int pilot = end - 1;
        int index_number_min = begin - 1;
        
        //index run begin to end in the array
        for (int index = begin; index < end - 1; index++) {
            //when array[index] <= array[pilot] --> count index min to 1 and swap index and index min
            if (array[index] <= array[pilot]) {
                index_number_min ++;
                int temp = array[index];
                array[index] = array[index_number_min];
                array[index_number_min] = temp;
            }
        }
        
        //after that swap pilot to after index min
        int temp = array[pilot];
        array[pilot] = array[index_number_min + 1];
        array[index_number_min + 1] = temp;
        return index_number_min + 1;
    }

    // function to enter each elements with random
    public static void inputElements(int[] array) {
        Random random = new Random();
        // select element from 0 to end array
        for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(array.length);
        }
    }

    // function to user input number of elements and return to main
    public static int inputNumberOfArray() {
        System.out.println("Enter number of array: ");
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        sc.close();

        return number;
    }

    // display array
    public static void displayArray(int[] array) {
        System.out.print("[");
        // select element from 0 to end array
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index]);
            // dont display "," with last elements
            if (index < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
