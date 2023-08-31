/**
 *Problem: 1326. Minimum Number of Taps to Open to Water a Garden
 *There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
 *There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 *Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 *Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 */

class Solution {
    //Greedy Algorithm with Dynamic "Farthest Reach" Adjustment
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n+1];
        Arrays.fill(arr,0);

        for(int i = 0; i < ranges.length; i++){
            if(ranges[i]==0) continue;
            int left = Math.max(0, i-ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        int end = 0, farCanReach = 0, cnt = 0;
        for(int i = 0; i<=n; i++){
            if(i>end){
                if(farCanReach <= end) return -1;
                end = farCanReach;
                cnt++;
            }
            farCanReach = Math.max(farCanReach, arr[i]);
        }

        return cnt + (end< n ? 1: 0); 
    }
}
/**
Complexity Analysis
Time Complexity: The algorithm runs in O(n)O(n)O(n) time because it only needs to traverse the array arr once.

Space Complexity: The space complexity is O(n)O(n)O(n) due to the additional array arr. */
