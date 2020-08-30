/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0002;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class J1SP0002 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arrayNumber = new int[inputNumberOfArray()];

        inputElements(arrayNumber);
        System.out.print("Unsorted array: ");
        displayArray(arrayNumber);
        selectionSort(arrayNumber);
        System.out.print("Sorted array: ");
        displayArray(arrayNumber);
    }
    
    //function use selection sort to sort array
    public static void selectionSort(int[] array) {
        int min_index;

        //select element from 0 to end array        
        for (int index = 0; index < array.length; index++) {
            min_index = index;

            //select element from index to end array
            for (int i = index; i < array.length; i++) {
                if (array[i] < array[min_index]) {
                    min_index = i;
                }
            }
            //swap 2 elements
            int temp = array[index];
            array[index] = array[min_index];
            array[min_index] = temp;
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
        sc.close();

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
}
