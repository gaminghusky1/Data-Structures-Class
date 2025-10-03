/*
 * FileOutputExample.java
 * Demo use of PrintWriter class to output to file
 */

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOutputExample {
    public static void main(String[] args) {
        Scanner scan = null;
        PrintWriter namesFile = null;
        PrintWriter scoresFile = null;
        try {
            // Can combine the two instantiations for a read:
            scan = new Scanner(new File("tests.txt"));

            // Create and open 2 output files
            namesFile = new PrintWriter("names.txt");
            scoresFile = new PrintWriter("scores.txt");

            // Read all students and their test scores
            // Store names and scores in separate files
            int score;
            String name;
            while (scan.hasNextLine()) {
                name = scan.nextLine();
                score = scan.nextInt();
                scan.nextLine();  // flush buffer after reading integer
                namesFile.println(name);
                scoresFile.println(score);
            }
        } catch (IOException exception) {
            System.out.println("Error processing file: " + exception);
        } finally {
            if (scan != null)
                scan.close();

            if (namesFile != null)
                namesFile.close();

            if (scoresFile != null)
                scoresFile.close();
        }
        System.out.println();
    }
}