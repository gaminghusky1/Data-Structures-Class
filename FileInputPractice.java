/*
 * FileInputPractice.java
 * Practice using Scanner class to input from file
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileInputPractice {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("outputPractice.txt"))) {
            // Open "outputPractice.txt" for input


            // Read all of the integers in the file
            // Calculate and display the smallest and largest values found
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            while (in.hasNextInt()) {
                int num = in.nextInt();
                min = Math.min(num, min);
                max = Math.max(num, max);
            }

            System.out.println("Smallest value: " + min);
            System.out.println("Largest value: " + max);
        } catch (IOException exception) {
            System.out.println("Error processing file: " + exception);
        }
    }
}