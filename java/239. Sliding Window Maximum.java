/**
 *Problem: 239. Sliding Window Maximum
 *You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *Return the max sliding window
 */

class Solution {
    //Monotonic Deque
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < k; i++){
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);
        
        for(int i = k; i < nums.length; i++){
            if(dq.peekFirst()== i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            
            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }
        //Return the result as an array.
        return res.stream().mapToInt(i->i).toArray();
    }
}
/**
Complexity:
Here n is the size of nums.
*** Time complexity: O(n). 
At first glance, it may look like the time complexity of this algorithm should be O(n^2), because there is a nested while loop inside the for loop. However, each element can only be added to the deque once, which means the deque is limited to n pushes. Every iteration of the while loop uses 1 pop, which means the while loop will not iterate more than n times in total, across all iterations of the for loop.
An easier way to think about this is that in the worst case, every element will be pushed and popped once. This gives a time complexity of O(2*n) = O(n).
*** Space complexity: O(k).
The size of the deque can grow a maximum up to a size of k.
*/
