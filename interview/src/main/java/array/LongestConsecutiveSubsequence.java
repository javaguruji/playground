package array;

import java.util.HashSet;

/**
 * @author badrikant.soni
 * https://www.geeksforgeeks.org/longest-consecutive-subsequence/
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Time complexity : O(n)
 */
public class LongestConsecutiveSubsequence {

    // Returns length of the longest consecutive subsequence
    static int findLongestConseqSubseq(int arr[],int n)
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i=0; i<n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start then update optimal length
        for (int i=0; i<n; ++i)
        {
            // if current element is the starting element of a sequence
            //if (!S.contains(arr[i]-1))
            //{
                // Then check for next elements in the sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this length is more
       /*         if (ans<j-arr[i])
                    ans = j-arr[i];*/
                ans = Math.max(ans, j - arr[i]);

            //}
        }
        return ans;
    }

    // Testing program
    public static void main(String args[])
    {
        int arr[] =  {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " +
                findLongestConseqSubseq(arr,n));
    }
}
