/**
 *Problem: 1342. Number of Steps to Reduce a Number to Zero
 *Given an integer num, return the number of steps to reduce it to zero.
 *In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
 
class Solution {
    public int numberOfSteps(int num) {
        int counter = 0;
        int number = num;
        while(number!=0){
            if(number%2==0){
            number = number/2;
            counter++;
            }else{
                counter++;
                number--;
            }
        }
        return counter;
    }
}
