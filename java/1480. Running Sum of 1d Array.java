/**
 *Problem: 1480. Running Sum of 1d Array
 *Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *Return the running sum of nums.
 */
 
class Solution {
    public int[] runningSum(int[] nums) {
        int[] respArray = nums;
        for(int i=1; i<nums.length; i++){
            respArray[i]=respArray[i-1]+nums[i];
        }
        return respArray;
    }
}
