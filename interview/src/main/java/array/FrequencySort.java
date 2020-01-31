package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author badrikant.soni
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 */
public class FrequencySort {

    public static void main(String[] args) {
        String input = "tree";
        System.out.println(frequencySort(input));

    }
    private static String frequencySort(String input) {

        // TreeMap gives order guarantees but hashMap doesn't give
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        for (char ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            int i = 0;
            Integer value = entry.getValue();
            while (i < value) {
                stringBuilder.append(entry.getKey());
                i++;
            }
        }
        return stringBuilder.toString();
    }
}
