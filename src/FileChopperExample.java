/*
 * FileChopperExample.java
 * Demo use of Scanner class to input from file a line at a time
 * and write output to a file.
 * Students from several states have gathered some temperature
 * readings over a week. Not every student gathered data every day.
 * Read in the data, writing the average temperature from each state
 * to a file with the state name.
 *
 * Input File Format:
 *    State Abbreviation      1 or more temps       Student Info
 *
 * Output File Format
 *    Average Temp (to nearest hundredth)    State
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileChopperExample {
    public static void main(String[] args) {
        try {
            // Construct File and Scanner objects for file "sample.txt"
            File inputFile = new File("sample.txt");
            Scanner scan = new Scanner(inputFile);

            // Create output file to hold average temp for each state
            PrintWriter allTemps = new PrintWriter("avgTemps.txt");

            // Read in each line of text. Calculate average temp for each
            // state, and write to output file.
            String line;
            double sum = 0;
            int count = 0;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                Scanner chop = new Scanner(line);
                String state = chop.next();
                while (chop.hasNext()) {
                    if (chop.hasNextInt()) {
                        sum += chop.nextInt();
                        ++count;
                    } else {
                        chop.next();
                    }

                }

                double avg = 0;
                if (count > 0)
                    avg = sum / count;
                allTemps.printf("%8.2f   %s\n", avg, state);
                count = 0;
                sum = 0;

            }
            System.out.println("Data written to avgTemps.txt");

            // Close streams
            scan.close();
            allTemps.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("Error opening file.\n" + fnf.getMessage());
        }
        System.out.println();
    }
}