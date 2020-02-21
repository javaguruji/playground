package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author badrikant.soni
 * http://prismoskills.appspot.com/lessons/Arrays/Anagrams.jsp
 *
 * Two words are said to be anagrams of each other if they are made up of same characters.
 *
 * If we have an array of words, then we want to group the words of one anagram together.
 *
 * For example:
 *
 * If input array is [“ram”, “pot”, “mar”, “top”, “arm”]
 *
 * Then output array should be [“ram”, “mar”, “arm”, “pot”, “top”]
 *
 * Solution 1 : A simple solution for this is to sort each word and put in a hash-map.
 * Solution 2 : Another solution is to sort each word and put in a trie.
 */
public class Anagram {

    public static void main(String[] args) {

        String[] words = {"ram", "pot", "mar", "top", "arm"};
        System.out.println(findAnagram(words));

    }

    private static String findAnagram(String[] words) {
        StringBuilder builder = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {

            // String sort
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // if sorted word is already present in map, then its anagram
            if (map.containsKey(sorted)) {
                builder.append(sorted);
                builder.append(",");
            } else {
                map.put(sorted, 1);
            }
        }
        return builder.toString();
    }
}
