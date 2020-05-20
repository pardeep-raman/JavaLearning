package collections.map.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int id;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int id, String description) {
        this.id = id;
        this.description = description;
        this.exits = new HashMap<>();
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

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
