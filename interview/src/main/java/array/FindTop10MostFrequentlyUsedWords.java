package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author badrikant.soni
 */
public class FindTop10MostFrequentlyUsedWords {

    public static void main(String[] args) {

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        //System.out.println(topKFrequent(words, 2));
        System.out.println(topKFrequentTest(words, 2));

    }

    private static List<String> topKFrequent(String[] words, int k) {
        List<String> stringList = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String word : words){
            if(countMap.containsKey(word)){
                countMap.put(word, countMap.get(word)+1);
            }else{
                countMap.put(word, 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = countMap.entrySet();
        for(Map.Entry<String, Integer> entry : entries){
            if(entry.getValue() == 2){
                stringList.add(entry.getKey());
            }
        }
        return stringList;
    }

    public static List<String> topKFrequentTest(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());


        Collections.sort(candidates, String::compareTo);

/*        (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1)*/

        return candidates.subList(0, k);
    }
}
