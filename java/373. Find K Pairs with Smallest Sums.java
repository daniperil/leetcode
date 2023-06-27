/**
 *Problem: 373. Find K Pairs with Smallest Sums
 *You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 */

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> resp = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] -b[0]);

        //The code above is a PriorityQueue of integer arrays (int[]) with a custom comparator. The comparator (a, b) -> a[0] - b[0] is used to define the priority order of elements in the queue.

//In this case, the elements in the priority queue are integer arrays, and the comparison is based on the value of the first element (a[0]) minus the value of the first element of the other array (b[0]).

        for(int x : nums1){
            pq.offer(new int[]{x+nums2[0],0});
        }

        while(k>0 && !pq.isEmpty()){
            int[] pair = pq.poll();
            int sum = pair[0];
            int pos = pair[1];

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum-nums2[pos]);
            currentPair.add(nums2[pos]);
            resp.add(currentPair);

            //If there are more elements in nums2, push the next pair into the priority queue
            if(pos+1<nums2.length){
                pq.offer(new int[]{sum-nums2[pos]+nums2[pos+1], pos+1});
            }

            k--;
        }

        return resp;
        
    }
}
