/**
 *Problem: 283. Move Zeroes
 *Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *Note that you must do this in-place without making a copy of the array.
 */

class Solution {
    public void moveZeroes(int[] nums) {

        if(nums == null || nums.length == 0) return;

        int insertPos = 0;
        for(int num:nums){
            //Inserts in 0 and then adds 1 to insertPos
            //It inserts the numbers once they are found and adds one to the counter.
            if(num!=0) nums[insertPos++] = num;
        }

       while(insertPos<nums.length){
           nums[insertPos++]=0;
       }
    }
}
