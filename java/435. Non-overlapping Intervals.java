/**
 *Problem: 435. Non-overlapping Intervals
 *Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Related to interval scheduling problem

        //Sorts intervales based on the second element of each interval
        //int[][] intervals = { {3, 5}, {1, 4}, {6, 9}, {2, 7} };
        // Before sorting: [ {3, 5}, {1, 4}, {6, 9}, {2, 7} ]
        //Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        // After sorting: [ {1, 4}, {3, 5}, {2, 7}, {6, 9} ]
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;

        for(int i = 0; i < intervals.length; i++){
            int x = intervals[i][0];
            int y = intervals[i][1];

            //Making sure an overlap won't be created
            //Update k since this interval is now the most recent interval
            if(x >= k){
                k = y;
            }
            else{
                ans++;
            }
        }
        return ans; 
    }
}
