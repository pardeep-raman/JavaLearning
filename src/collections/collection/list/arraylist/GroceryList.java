package collections.collection.list.arraylist;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String groceryItem) {
        groceryList.add(groceryItem);
    }

    public ArrayList<String> getGroceryList(){
        return groceryList;
    }

    public void printGroceryList() {
        if (groceryList.size() > 0)
            System.out.println("Grocery list is :");
        else
            System.out.println("No items in the list.");
        int itemNumber = 1;
        for (String item : groceryList) {
            System.out.println(itemNumber + ". " + item);
            itemNumber++;
        }
    }

    public void modifyGroceryItem(String oldItem, String newItem) {
        int position = findPositionOfItem(oldItem);
        if (position >= 0) {
            groceryList.set(position, newItem);
            System.out.println("Grocery item " + (position + 1) + " has been modified.");
        } else {
            System.out.println("Old item " + oldItem + " not found");
        }
    }

    public void removeGroceryItem(String item) {
        boolean isRemoved = groceryList.remove(item);
        if (isRemoved)
            System.out.println("Grocery item " + item + " has been removed.");
        else
            System.out.println("Grocery item " + item + " not found.");
    }

    public String findGroceryItem(String searchItem) {
        int postionOfItem = findPositionOfItem(searchItem);
        return postionOfItem >= 0 ? groceryList.get(postionOfItem) : null;
    }

    private int findPositionOfItem(String item) {
        return groceryList.indexOf(item);
    }
}
