/*
 * FileInputExample.java
 * Demo use of Scanner class to input from file
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileInputExample {
    public static void main(String[] args) throws IOException {
        // Construct File and Scanner objects for file "tests.txt"
        File inputFile = new File("tests.txt");
        if (inputFile.exists()) {
            Scanner scan = new Scanner(inputFile);

            // Read and display all students and their test scores
            int score;
            String name;
            while (scan.hasNextLine()) {
                name = scan.nextLine();
                score = scan.nextInt();
                scan.nextLine();  // flush input stream after reading integer
                System.out.printf("%-20s %4d \n", name, score);
            }
            System.out.println();

            // Close input stream by closing scan
            scan.close();
        } else {
            System.out.println("File \"tests.txt\" does not exist. Stopping.");
        }
    }
}