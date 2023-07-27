
/**
 *Problem: 2141. Maximum Running Time of N Computers
 *You have n computers. You are given the integer n and a 0-indexed integer array batteries where the ith battery can run a computer for batteries[i] minutes. You are interested in running all n computers simultaneously using the given batteries.
 *Initially, you can insert at most one battery into each computer. After that and at any integer time moment, you can remove a battery from a computer and insert another battery any number of times. The inserted battery can be a totally new battery or a battery from another computer. You may assume that the removing and inserting processes take no time.
 *Note that the batteries cannot be recharged.
 *Return the maximum number of minutes you can run all the n computers simultaneously.
 */

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        //Binary search
        Arrays.sort(batteries);
        //The method Arrays.stream() takes an array as input and returns a Stream of elements from that array.
        //The asLongStream() method converts the elements of the Stream into a LongStream, allowing us to perform the sum operation on long values.
        //sum(batteries)/n is the maximum time all computers can run if we could distribute the power of all batteries evenly among all the computers
        long left = 1, right = (long)Arrays.stream(batteries).asLongStream().sum()/n;
        while(left<right){
            long target = right - (right - left)/2;
            //Here, for each battery value, it calculates the minimum value between battery and the given target value. This operation effectively replaces each element in the stream with the minimum value between that element and target.
            long total = Arrays.stream(batteries).asLongStream().map(battery -> Math.min(battery,target)).sum();
            if(total >= target*n){
                left = target;
            }
            else{
                right = target-1;
            }
        }
        return left;
    }
}
/**
Time complexity: The time complexity for this problem is (O(m log k)), where (m) is the length of the input array batteries and (k) is the maximum power of one battery.

Space complexity: The space complexity for this problem is (O(1)). During the binary search, we only need to record the boundaries of the searching space and the power extra, and the accumulative sum of extra, which only takes constant space.
*/
