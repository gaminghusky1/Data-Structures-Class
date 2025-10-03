import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ArrayIntListMaster {
    public static void main(String[] args) {
        boolean completed = false;
        ArrayIntList valuesList = new ArrayIntList();
        Scanner userSelector = new Scanner(System.in);
        String userSelection;
        // As long as you haven't noted to quit
        while (!(completed)) {
            // List all options
            System.out.println("Would you like to \n" +
                    "\'A\' to add to the end.\n" +
                    "\'I\' to insert in the middle.\n" +
                    "\'D\' to delete a value.\n" +
                    "\'P\' to print all of the values.\n" +
                    "\'S\' to sort the array with mergesort\n" +
                    "\'F\' to find in array with binary search\n" +
                    "\'Q\' to quit.\n");
            // Take in an option from the user
            userSelection = userSelector.next();
            userSelector.nextLine();
            // If "A", call the add method
            if (userSelection.equals("A"))
                addToArrayList(valuesList, userSelector);

            // If "I", call the insert method
            if (userSelection.equals("I"))
                insertIntoArrayList(valuesList, userSelector);

            // If"D", call the delete method
            if (userSelection.equals("D"))
                deleteFromArrayList(valuesList, userSelector);

            // If "P", call the print method
            if (userSelection.equals("P"))
                printArrayList(valuesList);

            // If "S", sort the array
            if (userSelection.equals("S"))
                sortArrayList(valuesList);

            // If "F", find in array
            if (userSelection.equals("F"))
                findInArrayList(valuesList, userSelector);
            // If "Q"
            if (userSelection.equals("Q"))
                completed = true;
        }
        userSelector.close();
        System.exit(0);
    }

    public static void printArrayList(ArrayIntList valuesList) {
        System.out.println(valuesList);
    }

    public static void addToArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("What value would you like to add?");
        String newValue = userSelector.next();
        userSelector.nextLine();
        try {
             valuesList.add(Integer.parseInt(newValue));
        } catch (NumberFormatException e) {
            System.out.println("Invalid value received; no change");
        }
    }

    public static void deleteFromArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which index would you like to delete from?");
        String newSpotString = userSelector.next();
        userSelector.nextLine();
        try {
            int newSpot =  Integer.parseInt(newSpotString);
            if ((newSpot >= 0) && (newSpot < valuesList.size()))
                valuesList.remove(newSpot);
            else
                System.out.println("Invalid index received; no change");
        } catch (NumberFormatException e) {
            System.out.println("Invalid index received; no change");
        }
    }

    public static void insertIntoArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("At which index would you like to insert a value?");
        String newSpotString = userSelector.next();
        userSelector.nextLine();
        try {
            int newSpot = Integer.parseInt(newSpotString);
            if ((newSpot >= 0) && (newSpot <= valuesList.size()))
            {
                System.out.println("What value would you like to add?");
                String newValue = userSelector.next();
                userSelector.nextLine();
                valuesList.add(newSpot, Integer.parseInt(newValue));
            }
            else
                System.out.println("Invalid index received; no change");
        } catch (NumberFormatException e) {
            System.out.println("Invalid index or value received; no change");
        }
    }

    public static void sortArrayList(ArrayIntList valuesList) {
        valuesList.sort();
        System.out.println("Array sorted with mergesort.");
    }

    public static void findInArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which value would you like to search for in the array?");
        String valString = userSelector.next();
        userSelector.nextLine();
        try {
            int val = Integer.parseInt(valString);
            int idx = valuesList.binarySearch(val);
            if (idx < 0) {
                System.out.printf("Value not found in array, but can be inserted into index %d to keep array sorted.%n", -(idx + 1));
            } else {
                System.out.printf("Value found at index %d%n", idx);
            }
        } catch (NumberFormatException e) {
            System.out.println("Value must be an integer!");
        }
    }
}
