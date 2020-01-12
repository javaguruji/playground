package hashmap;

/**
 * @author badrikant.soni
 * Internals of HashMap : https://www.geeksforgeeks.org/internal-working-of-hashmap-java/
 * More : https://javabypatel.blogspot.com/2015/10/time-complexity-of-hashmap-get-and-put-operation.html
 * More : http://javabypatel.blogspot.com/2015/09/hashmap-data-structure-and-hashcode.html
 *
 */
public class Key {

    private String key;

    Key(String key) {
        this.key = key;
    }

    public int hashCode() {
        int hashValue = key.charAt(0);
        System.out.println("Hash Code for key = " + key + " : " + hashValue);
        return hashValue;
    }

    public boolean equals(Object object) {
        return this.key.equals(((Key)object).key);
    }
}
