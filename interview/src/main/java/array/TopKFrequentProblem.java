package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author badrikant.soni
 */
public class TopKFrequentProblem {

    public static void main(String[] args) {

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        //String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequentWords(words, 2));

        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequentElements(nums, 2));

    }

    /**
     *         https://leetcode.com/problems/top-k-frequent-words/
     *         Given a non-empty list of words, return the k most frequent elements.
     *
     *         Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
     *
     *         Example 1:
     *         Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     *         Output: ["i", "love"]
     *         Explanation: "i" and "love" are the two most frequent words.
     *             Note that "i" comes before "love" due to a lower alphabetical order.
     *         Example 2:
     *         Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     *         Output: ["the", "is", "sunny", "day"]
     *         Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     *             with the number of occurrence being 4, 3, 2 and 1 respectively.
     *             // Try to solve it in O(n log k) time and O(n) extra space.
     */
    private static List<String> topKFrequentWords(String[] words, int k) {
        List<String> stringList = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            if (countMap.containsKey(word)) {
                countMap.put(word, countMap.get(word) + 1);
            } else {
                countMap.put(word, 1);
            }
        }

        PriorityQueue<String> heap = new PriorityQueue<>((o1, o2) -> countMap.get(o1).equals(countMap.get(o2)) ? o2.compareTo(o1) : countMap.get(o1) - countMap.get(o2));
        for (String s : countMap.keySet()) {
            heap.add(s);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            stringList.add(heap.poll());
        }

        Collections.reverse(stringList);
        return stringList;
    }

    /**
     * @author badrikant.soni
     * https://leetcode.com/problems/top-k-frequent-elements/solution/
     *
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     * Note:
     *
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     *
     * solved in time complexity : O(k + log(n))
     */
    private static List<Integer> topKFrequentElements(int[] nums, int k) {

        // step 1 : insert the num(key) -> frequency(value) in the hashMap. It will take O(n)
        Map<Integer, Integer> count = new HashMap();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // step2 : Build min heap which is a priorityQueue data structure in Java
        // This is the Comparator the Priority Queue will use. It will look at the values of the keys and sort them in ascending order.
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> count.get(o1).equals(count.get(o2)) ? o2.compareTo(o1) : count.get(o1) - count.get(o2));

        // Step3 : Insert key in heap till k times.
        // adding element in heap takes O(log(k))
        // but if we do N times then, it will be O(N*log(k))
        for (int n : count.keySet()) {
            heap.add(n);

            // only k times insertion
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 4: Build an output list, O(klog(k)) time complexity.
        List<Integer> top_k = new ArrayList<>();
        while (!heap.isEmpty()) {
            top_k.add(heap.poll());
            Collections.reverse(top_k);
        }

        return top_k;
    }
}
/*
        Time Complexity : O(n) + O(nlogk) + O(klogk) => O(nlog(k))
        Space Complesity : O(n) to store the hashmap

 */