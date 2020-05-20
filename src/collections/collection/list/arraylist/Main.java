package collections.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    processList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    private static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print grocery items.");
        System.out.println("\t 2 - To add a grocery item in list.");
        System.out.println("\t 3 - To modify a grocery item in list.");
        System.out.println("\t 4 - To remove a grocery item from list.");
        System.out.println("\t 5 - To search a grocery item in list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem(){
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.println("Please enter the old item: ");
        String oldItem = scanner.nextLine();
        System.out.println("Please enter the new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(oldItem, newItem);
    }

    public static void removeItem(){
        System.out.println("Please enter the item to be removed: ");
        groceryList.removeGroceryItem(scanner.nextLine());
    }

    public static void searchItem(){
        System.out.println("Please enter the searched grocery item: ");
        String searchItem = scanner.nextLine();
        if (groceryList.findGroceryItem(searchItem)!= null){
            System.out.println("Found "+searchItem+" in the list.");
        }else {
            System.out.println(searchItem+" not found in the list.");
        }
    }

    public static void processList(){
        ArrayList<String> newList = new ArrayList<>();
        newList.addAll(groceryList.getGroceryList());
        ArrayList<String> newOtherList = new ArrayList<>(groceryList.getGroceryList());
        String[] array= new String[groceryList.getGroceryList().size()];
        array = groceryList.getGroceryList().toArray(array);
    }

}
