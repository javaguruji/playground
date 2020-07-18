package company.curefit;

import com.sun.org.apache.xml.internal.utils.Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author badrikant.soni
 */
public class AnagramTest {

    public static void main(String[] args) {

        Trie trie = new Trie();


        String[] words = {"ram", "pot", "mar", "top", "arm"};
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            System.out.println(word);
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.containsKey(sorted)){
                stringBuilder.append(sorted);
                stringBuilder.append(",");
            }else {
                map.put(sorted, 1);
            }

        }
        System.out.println(stringBuilder.toString());
    }
}
