package array;

import java.util.Comparator;

/**
 * @author badrikant.soni
 */
public class KString implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
