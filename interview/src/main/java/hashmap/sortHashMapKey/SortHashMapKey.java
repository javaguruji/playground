package hashmap.sortHashMapKey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author badrikant.soni
 * https://beginnersbook.com/2013/12/how-to-sort-hashmap-in-java-by-keys-and-values/
 */
public class SortHashMapKey {

    public static void main(String[] args) {

        // map doesn't maintain any order
        HashMap<Integer, String> map = new HashMap<>();
        map.put(5, "ab");
        map.put(8, "test");
        map.put(3, "test");
        map.put(2, "test");
        map.put(9, "test");
        map.put(10, "test");
        map.put(20, "test");
        map.put(1, "test");
        map.put(0, "test");
        System.out.println(map.keySet());

        // Treemap gives sorted order
        //TreeMap<Integer, String> treeMap = new TreeMap<>(map);
        //System.out.println(treeMap.keySet());


        // maintains the insertion order
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(map);
        System.out.println(linkedHashMap.keySet());


        // Now let's sort the HashMap by values
        // there is no direct way to sort HashMap by values but you
        // can do this by writing your own comparator, which takes
        // Map.Entry object and arrange them in order increasing
        // or decreasing by values.
        Comparator<Map.Entry<Integer, String>> valueComparator = new Comparator<Map.Entry<Integer,String>>() {

            @Override
            public int compare(Map.Entry<Integer, String> e1, Map.Entry<Integer, String> e2) {
                String v1 = e1.getValue();
                String v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };

        // Sort method needs a List, so let's first convert Set to List in Java
        List<Map.Entry<Integer, String>> listOfEntries = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());

        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        System.out.println(listOfEntries);


    }
}
