/**
 *Problem: 1266. Minimum Time Visiting All Points
 *On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.
 *You can move according to these rules:
 *In 1 second, you can either:
 *move vertically by one unit,
 *move horizontally by one unit, or
 *move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
 *You have to visit the points in the same order as they appear in the array.
 *You are allowed to pass through points that appear later in the order, but these do not count as visits.
 */

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        //Move Diagonally as Much as Possible
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int currX = points[i][0];
            int currY = points[i][1];
            int targetX = points[i + 1][0];
            int targetY = points[i + 1][1];
            ans += Math.max(Math.abs(targetX - currX), Math.abs(targetY - currY));
        }
        
        return ans;
    }
}
