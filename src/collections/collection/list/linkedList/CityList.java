package collections.collection.list.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class CityList {

    private LinkedList<String> cityList = new LinkedList<>();

    public boolean addCity(String city) {
        ListIterator<String> listIterator = cityList.listIterator();
        while (listIterator.hasNext()) {
            int comparison = listIterator.next().compareTo(city);
            if (comparison == 0) {
                System.out.println("City " + city + " already added.");
                return false;
            } else if (comparison > 0) {
                listIterator.previous();
                listIterator.add(city);
                return true;
            }
        }
        listIterator.add(city);
        return true;
    }

    public LinkedList<String> getCityList() {
        return cityList;
    }

    public void printCityListInForwardDirection() {
        ListIterator<String> iterator = cityList.listIterator();
        if (cityList.isEmpty())
            System.out.println("No city in the list.");
        else
            System.out.println("City list is :");

        int itemNumber = 1;
        while (iterator.hasNext()) {
            System.out.println(itemNumber + ". " + iterator.next());
            itemNumber++;
        }
    }

    public void printCityListInBackwardDirection() {
        ListIterator<String> iterator = cityList.listIterator(cityList.size());
        if (cityList.isEmpty())
            System.out.println("No city in the list.");
        else
            System.out.println("City list is :");
        int itemNumber = cityList.size();
        while (iterator.hasPrevious()) {
            System.out.println(itemNumber + ". " + iterator.previous());
            itemNumber--;
        }
    }

    public void modifyCity(String oldCity, String newCity) {
        int position = findPositionOfCity(oldCity);
        if (position >= 0) {
            cityList.set(position, newCity);
            System.out.println("City " + oldCity + " has been replaced with " + newCity);
        } else {
            System.out.println("Old city " + oldCity + " not found");
        }
    }

    public void removeCity(String city) {
        boolean isRemoved = cityList.remove(city);
        if (isRemoved)
            System.out.println("City " + city + " has been removed.");
        else
            System.out.println("City " + city + " not found.");
    }

    public String findCity(String searchCity) {
        int postionOfCity = findPositionOfCity(searchCity);
        return postionOfCity >= 0 ? cityList.get(postionOfCity) : null;
    }

    private int findPositionOfCity(String city) {
        return cityList.indexOf(city);
    }
}
