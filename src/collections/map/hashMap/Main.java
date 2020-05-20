package collections.map.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        if (languages.containsKey("Java")) {
            System.out.println("Java is already present");
        } else {
            languages.put("Java", "Object Oriented and platform independent");
            System.out.println("Java added successfully");
        }
        languages.put("Python", "High level programming language");
        System.out.println(languages.put("Algol", "An algorithmic language"));
        languages.put("Kotlin", "Very useful and latest language for android.");

        System.out.println(languages.get("Java"));
        if (languages.containsKey("Java")) {
            System.out.println("Java is already present");
        } else {
            languages.put("Java", "This is about Java.");
        }

        System.out.println("=====================================");
        Iterator<String> iterator = languages.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " : " + languages.get(key));
        }

        System.out.println("=====================================");

        if (languages.remove("Java", "This is Java")) {
            System.out.println("Java is removed");
        } else {
            System.out.println("Java not removed as key/value pair not found");
        }

        System.out.println("=====================================");

        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

        System.out.println(languages.replace("Kotlin","This is kotlin language."));
        System.out.println(languages.replace("Java","It is Java", "It is new Java"));
        System.out.println(languages.replace("Scala","Not added yet"));
    }
}
