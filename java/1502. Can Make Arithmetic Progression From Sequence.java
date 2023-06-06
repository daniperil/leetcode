/**
 *Problem: 1502. Can Make Arithmetic Progression From Sequence
 *A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 *Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
 */
 
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        boolean resp = true;
        if(arr.length == 2){
            return resp;
        }

        int diffx = 0;
        int diffy = 0;
        Arrays.sort(arr);
        diffx = Math.abs(arr[1]-arr[0]);

        for(int i = 2; i<arr.length; i++){
             diffy = Math.abs(arr[i]-arr[i-1]);
             if(diffx != diffy){
                 resp = false;
             }
        }
        return resp;
        
    }
}
