/**
 *Problem: 2366. Minimum Replacements to Sort the Array
 *You are given a 0-indexed integer array nums. In one operation you can replace any element of the array with any two elements that sum to it.
 *For example, consider nums = [5,6,7]. In one operation, we can replace nums[1] with 2 and 4 and convert nums to [5,2,4,7].
 *Return the minimum number of operations to make an array that is sorted in non-decreasing order.
 */

class Solution {
    //Greedy
    public long minimumReplacement(int[] nums) {
        long operations = 0;
        long prevBound = nums[nums.length-1];

        for(int i = nums.length-2; i>=0; i--){
            long num = nums[i];
            long nTimes = (num + prevBound -1)/ prevBound;
            operations += nTimes-1;
            prevBound = num/nTimes;
        }

        return operations;
        
    }
}
