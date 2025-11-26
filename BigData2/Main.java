package BigData2;

import java.io.IOException;

// The following class contains some example calls for sorting, binary search, and averaging entries.
public class Main {
    public static void main(String[] args) throws IOException {
        // Create the holder and read in the data
        StockDataHolder sdh = new StockDataHolder("/Users/JustinMa/IdeaProjects/Data-Structures-Class/BigData2/GameStop_Data.csv");

        // Current first element
        System.out.println("First element before sorting:\n" + sdh.get(0));

        // Sort by Date and print new first element
        sdh.sortBy("Date");
        System.out.println("First element after sorting by Date:\n" + sdh.get(0));

        // Binary search by Close/Last
        System.out.println("Binary Search for Close/Last value of $27.77:\n" + sdh.binarySearch("Close/Last", "$27.77"));
        // Binary search returns null if the value doesn't exist
        System.out.println("Binary Search for Close/Last value of $0.00:\n" + sdh.binarySearch("Close/Last", "$0.00"));

        // Find the average Volume between dates
        System.out.println("Average Volume between 07/22/2019 and 07/07/2020:\n" + sdh.getAverageBetween("07/19/2019", "07/07/2020", "Volume"));

        // Find the average Opening value between dates
        System.out.println("Average Open between 08/10/2023 and 10/01/2025:\n" + sdh.getAverageBetween("08/10/2023", "10/01/2025", "Open"));
    }
}
