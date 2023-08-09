/**
 *Problem: 2616. Minimize the Maximum Difference of Pairs
 *You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.
 *Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.
 *Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
 */

class Solution {
    //Binary search & greedy
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int left = 0, right = nums[nums.length - 1] - nums[0];

        while(left<right){
            int mid = (left+right)/2;
            if(canFormPairs(nums,mid, p)){
                right = mid;
            }
            else{
                left = mid +1;
            }
        }
        return left;
    }
    

    private boolean canFormPairs(int[] nums, int mid, int p){
        int count = 0;
        for(int i = 0; i<nums.length-1 && count<p;){
            if(nums[i+1]-nums[i] <= mid){
                count++;
                i+=2;
            }
            else{
                i++;
            }
        }
        return count >= p;
    }
}

/**
Complexity
Time Complexity: O(n log m), where nnn is the length of the array and mmm is the difference between the maximum and minimum values in the array. Sorting the array takes O(n log n) and the binary search process, combined with the greedy check, takes O(n log m).

Space Complexity: O(1). We only use a constant amount of space for our variables. */
