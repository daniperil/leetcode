/**
 *Problem: 1218. Longest Arithmetic Subsequence of Given Difference
 *Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
 *A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
 */

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        //Dynamic programming apprach
        //The key idea of the DP approach is to use a hash map dp to store the maximum length of an arithmetic subsequence that ends with each element in arr.
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 1;

        for(int a : arr){
            int beforeA = dp.getOrDefault(a-difference,0);
            dp.put(a,beforeA+1);
            answer = Math.max(answer,dp.get(a));
        }
        return answer;
    }
}
