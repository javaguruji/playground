package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author badrikant.soni
 * https://javarevisited.blogspot.com/2014/03/3-ways-to-find-first-non-repeated-character-String-programming-problem.html
 * for example in the world "hello", except 'l' all are non-repeated, but 'h' is the first non-repeated character
 *
 */
public class FirstNonRepeatingCharacterInString {

    public static void main(String[] args) {

        String input = "hello"; // non repeating characters are 'heo' // first non repeating is 'h'
        //bruteForce(input);
        System.out.println(firstNonRepeatingChar(input));
        System.out.println(firstNonRepeatingCharUsingLinkedHashMap(input));
        System.out.println(firstNonRepeatingCharUsingHashMap(input));


    }

    public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        System.out.println(nonRepeating);
        System.out.println(repeating);
        return nonRepeating.get(0);
    }


    // LinkedHashMap maintains insertion order
    private static char firstNonRepeatingCharUsingLinkedHashMap(String word) {

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char ch : word.toCharArray()) {
            if (countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) + 1);
            } else {
                countMap.put(ch, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entries = countMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find");
    }

    // HashMap doesn't maintain any orders
    private static char firstNonRepeatingCharUsingHashMap(String word) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : word.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (countMap.get(ch) == 1) {
                return ch;
            }
        }
        throw new RuntimeException("didn't find");
    }
}
