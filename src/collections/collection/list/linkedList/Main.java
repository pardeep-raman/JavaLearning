package collections.collection.list.linkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static CityList cityList = new CityList();

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
                    cityList.printCityListInForwardDirection();
                    break;
                case 2:
                    cityList.printCityListInBackwardDirection();
                    break;
                case 3:
                    addCity();
                    break;
                case 4:
                    modifyCity();
                    break;
                case 5:
                    removeCity();
                    break;
                case 6:
                    searchCity();
                    break;
                case 7:
                    processList();
                    break;
                case 8:
                    quit = true;
                    break;
            }
        }
    }

    private static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print cities in forward direction.");
        System.out.println("\t 2 - To print cities in backward direction.");
        System.out.println("\t 3 - To add a city in list.");
        System.out.println("\t 4 - To modify a city in list.");
        System.out.println("\t 5 - To remove a city from list.");
        System.out.println("\t 6 - To search a city in list.");
        System.out.println("\t 7 - To quit the application.");
    }

    public static void addCity(){
        System.out.println("Please enter the city: ");
        cityList.addCity(scanner.nextLine());
    }

    public static void modifyCity(){
        System.out.println("Please enter the old city: ");
        String oldCity = scanner.nextLine();
        System.out.println("Please enter the new city: ");
        String newCity = scanner.nextLine();
        cityList.modifyCity(oldCity, newCity);
    }

    public static void removeCity(){
        System.out.println("Please enter the city to be removed: ");
        cityList.removeCity(scanner.nextLine());
    }

    public static void searchCity(){
        System.out.println("Please enter the searched city: ");
        String searchCity = scanner.nextLine();
        if (cityList.findCity(searchCity)!= null){
            System.out.println("Found "+searchCity+" in the list.");
        }else {
            System.out.println(searchCity+" not found in the list.");
        }
    }

    public static void processList(){
        LinkedList<String> newList = new LinkedList<>();
        newList.addAll(cityList.getCityList());
        LinkedList<String> newOtherList = new LinkedList<>(cityList.getCityList());
        String[] array= new String[cityList.getCityList().size()];
        array = cityList.getCityList().toArray(array);
    }
}
