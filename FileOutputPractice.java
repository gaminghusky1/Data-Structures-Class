/*
 * FileOutputPractice.java
 * Demo use of PrintWriter class to output to file
 */

import java.io.IOException;
import java.io.PrintWriter;

public class FileOutputPractice {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter("outputPractice.txt")) {
            // Open the outputPractice.txt file for output

            // Generate the random integer in range [50, 60]
            // this is the number of integers to be output
            int numOutput = (int) (Math.random() * 11 + 50);

            // Generate the chosen number of random integers in
            // the range [100, 200] and write them to the file.
            for (int i = 0; i < numOutput; ++i) {
                out.println((int) (Math.random() * 101 + 100));
            }

            // Close the file!

        } catch (IOException exception) {
            System.out.println("Error processing file: " + exception);
        }
    }
}