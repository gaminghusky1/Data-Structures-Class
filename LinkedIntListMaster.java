import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LinkedIntListMaster {
    public static void main(String[] args) {
        boolean completed = false;
        LinkedIntList valuesList = new LinkedIntList();
        Scanner userSelector = new Scanner(System.in);
        String userSelection;
        // As long as you haven't noted to quit
        while (!(completed)) {
            // List all options
            System.out.println("Would you like to \n" +
                    "'A' to add to the end.\n" +
                    "'I' to insert in the middle.\n" +
                    "'As' to add a value in a way that keeps the list sorted (Precondition: list is already sorted).\n" +
                    "'G' to get a value at an index.\n" +
                    "'S' to set the value at an index.\n" +
                    "'Sz' to get the size of the LinkedList.\n" +
                    "'E' to see if the LinkedList is empty.\n" +
                    "'D' to delete a value at an index.\n" +
                    "'F' to find in LinkedList with linear search.\n" +
                    "'C' to see if the LinkedList contains a specific element.\n" +
                    "'P' to print all of the values.\n" +
                    "'Srt' to sort the LinkedList with mergesort.\n" +
                    "'Clr' to clear the LinkedList.\n" +
                    "'Q' to quit.\n");
            // Take in an option from the user
            userSelection = userSelector.next();
            userSelector.nextLine();
            switch (userSelection) {
                case "A":
                    addToLinkedList(valuesList, userSelector);
                    break;

                case "I":
                    insertIntoLinkedList(valuesList, userSelector);
                    break;

                case "As":
                    addSortedIntoLinkedList(valuesList, userSelector);
                    break;

                case "G":
                    getFromLinkedList(valuesList, userSelector);
                    break;

                case "S":
                    setInLinkedList(valuesList, userSelector);
                    break;

                case "Sz":
                    getLinkedListSize(valuesList);
                    break;

                case "E":
                    getLinkedListEmptyState(valuesList);
                    break;

                case "D":
                    deleteFromLinkedList(valuesList, userSelector);
                    break;

                case "F":
                    findInLinkedList(valuesList, userSelector);
                    break;

                case "C":
                    doesLinkedListContain(valuesList, userSelector);
                    break;

                case "P":
                    printLinkedList(valuesList);
                    break;

                case "Srt":
                    sortLinkedList(valuesList);
                    break;
                    
                case "Clr":
                    clearLinkedList(valuesList);
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

    public static void addToLinkedList(LinkedIntList valuesList, Scanner userSelector) {
        System.out.println("What value would you like to add?");
        try {
             valuesList.add(Integer.parseInt(userSelector.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid value received; no change");
        }
    }

    public static void insertIntoLinkedList(LinkedIntList valuesList, Scanner userSelector) {
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

    public static void addSortedIntoLinkedList(LinkedIntList valuesList, Scanner userSelector) {
        System.out.println("What value would you like to add?");
        try {
            int val = Integer.parseInt(userSelector.nextLine());
            valuesList.addSorted(val);
        } catch (NumberFormatException e) {
            System.out.println("Invalid value received; no change");
        }
    }

    public static void getFromLinkedList(LinkedIntList valuesList, Scanner userSelector) {
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

    public static void setInLinkedList(LinkedIntList valuesList, Scanner userSelector) {
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

    public static void getLinkedListSize(LinkedIntList valuesList) {
        System.out.printf("The LinkedList is of size %d\n", valuesList.size());
    }

    public static void getLinkedListEmptyState(LinkedIntList valuesList) {
        if (valuesList.isEmpty()) {
            System.out.println("The LinkedList is empty");
        } else {
            System.out.println("The LinkedList is not empty");
        }
    }

    public static void deleteFromLinkedList(LinkedIntList valuesList, Scanner userSelector) {
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

    public static void findInLinkedList(LinkedIntList valuesList, Scanner userSelector) {
        System.out.println("Which value would you like to search for in the LinkedList?");
        try {
            int val = Integer.parseInt(userSelector.nextLine());
            int idx = valuesList.indexOf(val);
            if (idx < 0) {
                System.out.println("Value not found in LinkedList.");
            } else {
                System.out.printf("Value found at index %d%n", idx);
            }
        } catch (NumberFormatException e) {
            System.out.println("Value must be an integer!");
        }
    }

    public static void doesLinkedListContain(LinkedIntList valuesList, Scanner userSelector) {
        System.out.println("Which value would you like to check whether the LinkedList contains?");
        try {
            if (valuesList.contains(Integer.parseInt(userSelector.nextLine()))) {
                System.out.println("The LinkedList does contain that value.");
            } else {
                System.out.println("The LinkedList does not contain that value.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid value received");
        }
    }

    public static void printLinkedList(LinkedIntList valuesList) {
        System.out.println(valuesList);
    }

    public static void sortLinkedList(LinkedIntList valuesList) {
        valuesList.sort();
        System.out.println("LinkedList sorted with mergesort.");
    }

    public static void clearLinkedList(LinkedIntList valuesList) {
        valuesList.clear();
        System.out.println("LinkedList cleared.");
    }
}
