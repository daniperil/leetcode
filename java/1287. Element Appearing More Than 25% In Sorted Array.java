
/**
 *Problem: 1287. Element Appearing More Than 25% In Sorted Array
 *Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
 */

class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> counts = new HashMap();
        int target = arr.length/4;
        for(int num : arr){
            counts.put(num, counts.getOrDefault(num,0)+1);
            if(counts.get(num)>target){
                return num;
            }
        }

        return -1;
        
    }
}
/**
Time complexity: O(n)O(n)O(n)

We iterate over arr once to calculate counts. This costs O(n)O(n)O(n). Next, we iterate over counts, which also costs O(n)O(n)O(n).

Space complexity: O(n)O(n)O(n)

In the worst-case scenario, counts can contain at most O(n)O(n)O(n) keys and thus grow to a size of O(n)O(n)O(n).*/
