package hashtable;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author badrikant.soni
 * Reference : https://howtodoinjava.com/java/collections/hashtable-class/
 */
public class HashTableExample {

    public static void main(String[] args) {

        Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();

        hashtable.put(1, "A");
        hashtable.put(2, "B");
        hashtable.put(3, "C");
        //hashtable.put(null, "D");  // doesn't access null as key, it will throw NPE
        //hashtable.put(null, null);   // doesn't accept null as key or value , throw NPE.
        hashtable.put(3, "D");  // In case duplicate key, it will override old value and replace with new value. o/p =>  key = 3, value = D

        System.out.println(hashtable);

        String s = hashtable.get(1);
        System.out.println(s);

        Iterator<Integer> iterator = hashtable.keySet().iterator();
        while(iterator.hasNext()){
            Integer key = iterator.next();
            String value = hashtable.get(key);
            System.out.println("Key : "+ key + " , " + "Value : "+ value);
        }

    }
}
