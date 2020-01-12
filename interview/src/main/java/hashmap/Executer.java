package hashmap;

import java.util.HashMap;

/**
 * @author badrikant.soni
 */
public class Executer {

    public static void main(String[] args) {

        HashMap<Key, Integer> map = new HashMap<Key, Integer>();
        map.put(new Key("vishal"), 20);
        map.put(new Key("sachin"), 10);

        System.out.println();
        System.out.println("Value for Vishal " + map.get(new Key("vishal")));
        System.out.println("Value for sachin " + map.get(new Key("sachin")));

    }
}
