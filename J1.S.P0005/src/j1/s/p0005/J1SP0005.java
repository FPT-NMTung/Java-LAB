/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0005;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class J1SP0005 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arrayNumber = new int[inputNumberOfArray()];
        //int[] arrayNumber = {1, 3, 5, 2, 8, 6, 4, 7};
        
        inputElements(arrayNumber);
        System.out.print("Unsorted array: ");
        displayArray(arrayNumber);
        mergesort(arrayNumber, 0, arrayNumber.length);
        System.out.print("Sorted array: ");
        displayArray(arrayNumber);
    }
    
    // function use meagr sort to sort array
    public static void mergesort (int[] array, int begin, int end) {        
        int point = (end + begin)/2;
        int[] arrayTemp = new int[end - begin];  
        
        if (end != begin + 1) {    
            mergesort(array, begin, point);
            mergesort(array, point, end);
            
            //create a array temp for group elements                      
            int index = 0;
            
            int index_first = begin;
            int index_second = point;
            
            //group elements     
            while (index_first != point && index_second != end) {
                if (array[index_first] <= array[index_second]) {
                    arrayTemp[index] = array[index_first];
                    index_first ++;
                    index ++;
                } else {
                    arrayTemp[index] = array[index_second];
                    index_second ++;
                    index ++;
                }
            } 
            
            //move the rest of the elements to arrayTemp
            if (index_first == point) {
                for (int i = index_second; i < end; i++) {
                    arrayTemp[index] = array[i];
                    index++;
                }
            }
            if (index_second == end) {
                for (int i = index_first; i < point; i++) {
                    arrayTemp[index] = array[i];
                    index++;
                }
            }
            
            //move all elements to array
            index = 0;
            for (int i = begin; i < end; i++) {
                array[i] = arrayTemp[index];
                index++;
            }
        }
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
