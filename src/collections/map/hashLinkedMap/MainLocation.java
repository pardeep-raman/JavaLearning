package collections.map.hashLinkedMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainLocation {

    private static LinkedHashMap<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are back Home"));
        locations.put(1, new Location(1, "You are on Road"));
        locations.put(2, new Location(2, "You are at Hill"));
        locations.put(3, new Location(3, "You are at School"));
        locations.put(4, new Location(4, "You are at Valley"));
        locations.put(5, new Location(5, "You are at Forest"));

        System.out.println("Locations are : ");
        for (Integer id : locations.keySet()) {
            System.out.println("\t" + id + " : " + locations.get(id).getDescription());
        }

        locations.get(1).addExit("North", 5);
        locations.get(1).addExit("South", 4);
        locations.get(1).addExit("East", 3);
        locations.get(1).addExit("West", 2);

        locations.get(2).addExit("North", 5);

        locations.get(3).addExit("West", 1);

        locations.get(4).addExit("North", 1);
        locations.get(4).addExit("West", 2);

        locations.get(5).addExit("South", 1);
        locations.get(5).addExit("West", 2);

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You can't go in that direction");
            }
        }

    }
}
