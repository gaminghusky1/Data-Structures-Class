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
                    "'A' to add to the end.\n" +
                    "'I' to insert in the middle.\n" +
                    "'G' to get a value at an index.\n" +
                    "'S' to set the value at an index.\n" +
                    "'Sz' to get the size of the ArrayList.\n" +
                    "'E' to see if the ArrayList is empty.\n" +
                    "'D' to delete a value at an index.\n" +
                    "'F' to find in array with linear search.\n" +
                    "'FB' to find in array with binary search (only to be used after sorting array, otherwise behavior is undefined).\n" +
                    "'C' to see if the ArrayList contains a specific element.\n" +
                    "'P' to print all of the values.\n" +
                    "'Srt' to sort the array with mergesort.\n" +
                    "'Q' to quit.\n");
            // Take in an option from the user
            userSelection = userSelector.next();
            userSelector.nextLine();
            switch (userSelection) {
                case "A":
                    addToArrayList(valuesList, userSelector);
                    break;

                case "I":
                    insertIntoArrayList(valuesList, userSelector);
                    break;

                case "G":
                    getFromArrayList(valuesList, userSelector);
                    break;

                case "S":
                    setInArrayList(valuesList, userSelector);
                    break;

                case "Sz":
                    getArrayListSize(valuesList);
                    break;

                case "E":
                    getArrayListEmptyState(valuesList);
                    break;

                case "D":
                    deleteFromArrayList(valuesList, userSelector);
                    break;

                case "F":
                    findInArrayList(valuesList, userSelector);
                    break;

                case "FB":
                    binarySearchArrayList(valuesList, userSelector);
                    break;

                case "C":
                    doesArrayListContain(valuesList, userSelector);
                    break;

                case "P":
                    printArrayList(valuesList);
                    break;

                case "Srt":
                    sortArrayList(valuesList);
                    break;

                case "Q":
                    completed = true;
                    break;

                default:
                    System.out.println("Invalid selection: " + userSelection);
            }
        }
        userSelector.close();
        System.exit(0);
    }

    public static void addToArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("What value would you like to add?");
        try {
             valuesList.add(Integer.parseInt(userSelector.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid value received; no change");
        }
    }

    public static void insertIntoArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("At which index would you like to insert a value?");
        try {
            int idx = Integer.parseInt(userSelector.nextLine());
            if ((idx >= 0) && (idx <= valuesList.size()))
            {
                System.out.println("What value would you like to add?");
                valuesList.add(idx, Integer.parseInt(userSelector.nextLine()));
            }
            else
                System.out.println("Invalid index received; no change");
        } catch (NumberFormatException e) {
            System.out.println("Invalid index or value received; no change");
        }
    }

    public static void getFromArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which index would you like to get the value of?");
        try {
            int idx = Integer.parseInt(userSelector.nextLine());
            if ((idx >= 0) && (idx < valuesList.size())) {
                System.out.printf("Value at index %d is %d\n", idx, valuesList.get(idx));
            } else {
                System.out.println("Invalid index received");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid index received");
        }
    }

    public static void setInArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which index would you like to set the value of?");
        try {
            int idx = Integer.parseInt(userSelector.nextLine());
            if ((idx >= 0) && (idx < valuesList.size())) {
                System.out.println("What value would you like to set that index to?");
                valuesList.set(idx, Integer.parseInt(userSelector.nextLine()));
            } else {
                System.out.println("Invalid index received; no change");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid index or value received; no change");
        }
    }

    public static void getArrayListSize(ArrayIntList valuesList) {
        System.out.printf("The ArrayList is of size %d\n", valuesList.size());
    }

    public static void getArrayListEmptyState(ArrayIntList valuesList) {
        if (valuesList.isEmpty()) {
            System.out.println("The ArrayList is empty");
        } else {
            System.out.println("The ArrayList is not empty");
        }
    }

    public static void deleteFromArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which index would you like to delete from?");
        try {
            int idx = Integer.parseInt(userSelector.nextLine());
            if ((idx >= 0) && (idx < valuesList.size()))
                valuesList.remove(idx);
            else
                System.out.println("Invalid index received; no change");
        } catch (NumberFormatException e) {
            System.out.println("Invalid index received; no change");
        }
    }

    public static void findInArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which value would you like to search for in the array?");
        try {
            int val = Integer.parseInt(userSelector.nextLine());
            int idx = valuesList.indexOf(val);
            if (idx < 0) {
                System.out.println("Value not found in array.");
            } else {
                System.out.printf("Value found at index %d%n", idx);
            }
        } catch (NumberFormatException e) {
            System.out.println("Value must be an integer!");
        }
    }

    public static void binarySearchArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which value would you like to search for in the array?");
        try {
            int val = Integer.parseInt(userSelector.nextLine());
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

    public static void doesArrayListContain(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which value would you like to check whether the ArrayList contains?");
        try {
            if (valuesList.contains(Integer.parseInt(userSelector.nextLine()))) {
                System.out.println("The ArrayList does contain that value.");
            } else {
                System.out.println("The ArrayList does not contain that value.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid value received");
        }
    }

    public static void printArrayList(ArrayIntList valuesList) {
        System.out.println(valuesList);
    }

    public static void sortArrayList(ArrayIntList valuesList) {
        valuesList.sort();
        System.out.println("Array sorted with mergesort.");
    }
}
