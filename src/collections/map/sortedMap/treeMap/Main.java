package collections.map.sortedMap.treeMap;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<Integer,String> employees = new TreeMap<>();
        employees.put(1,"Varun");
        employees.put(5,"Kishore");
        employees.put(3,"Sahil");
        employees.put(4,"Yash");
        employees.put(6,"Antima");
        employees.put(2,"Arjun");

        System.out.println("Employees are : ");
        Iterator<Integer> integerIterator= employees.keySet().iterator();
        while (integerIterator.hasNext()){
            Integer key= integerIterator.next();
            System.out.println(key+". "+employees.get(key));
        }

        employees.remove(4);

        System.out.println("========================");

        System.out.println("Employees are : ");
        Iterator<Map.Entry<Integer,String>> iterator= employees.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry= iterator.next();
            System.out.println(entry.getKey()+". "+entry.getValue());
        }

        NavigableMap<Integer,String> map=new TreeMap<>();
        map.put(1,"Anju");
        map.put(2,"Kiran");
        map.put(3,"Poonam");
        map.put(4,"Sonia");
        System.out.println("DescendingMap: "+map.descendingMap());
        System.out.println("HeadMap: "+map.headMap(2,true));
        System.out.println("TailMap: "+map.tailMap(2,true));
        System.out.println("SubMap: "+map.subMap(1, false, 3, true));
    }
}
