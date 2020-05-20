package collections.map.hashLinkedMap;

import java.util.LinkedHashMap;

public class Location {
    private final int id;
    private final String description;
    private final LinkedHashMap<String,Integer> exits;

    public Location(int id, String description) {
        this.id = id;
        this.description = description;
        this.exits = new LinkedHashMap<>();
        exits.put("Quit",0);
    }

    public void addExit(String direction, int id){
        exits.put(direction,id);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LinkedHashMap<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }
}
