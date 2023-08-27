/**
 *Problem: 403. Frog Jump
 *A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 *If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 */

class Solution {
    //Top-Down Dynamic Programming

    HashMap<Integer, Integer> mark = new HashMap<>();
    int dp[][] = new int[2001][2001];
    
    boolean solve(int[] stones, int n, int index, int prevJump) {
        // If reached the last stone, return 1.
        if (index == n - 1) {
            return true;
        }
        
        // If this subproblem has already been calculated, return it.
        if (dp[index][prevJump] != -1) {
            return dp[index][prevJump] == 1;
        }
        
        boolean ans = false;
        // Iterate over the three possibilities {k - 1, k, k + 1}.
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0 && mark.containsKey(stones[index] + nextJump)) {
                ans = ans || solve(stones, n, mark.get(stones[index] + nextJump), nextJump);
            }
        }

        // Store the result to fetch later.
        dp[index][prevJump] = (ans ? 1 :0);
        return ans;
    }
    
    public boolean canCross(int[] stones) {
        // Mark stones in the map to identify if such stone exists or not.
        for (int i = 0 ; i < stones.length; i++) {
            mark.put(stones[i], i);
        }
        
        //Mark all states as -1 to denote they're not calculated.
        for (int i = 0; i < 2000; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(stones, stones.length, 0, 0);
    }
}
/**
Complexity Analysis

Here, NNN is the number of stones in the river.

Time complexity: O(N2)O(N^2)O(N 
2
 )

Each state is defined by the values index and prevJump. Hence, there will be N2N^2N 
2
  possible states because both index and jump can take up to NNN values; this is because if there are NNN stones, the frog can only jump on them in the forward direction, so if the frog chooses the maximum jump in every case and there is a stone on those jumps position as well then the value of prevJump will be {0, 1, 2, 3, 4, 5, 6.....} and since the jumps could not be more than the number of stones the value of prevStone would also be not more than NNN. We must visit these states to solve the original problem. Each recursive call requires O(1)O(1)O(1) time, as we have a loop with three iterations. Thus, the total time complexity equals O(N2)O(N^2)O(N 
2
 ).

Space complexity: O(N2)O(N^2)O(N 
2
 )

The size of the dp array is N2N^2N 
2
 ; also, the size of the map mark is NNN (although the keys are the values of stones' position, the number of entries would be equal to the number of stones). There would be some stack space, too; the maximum number of active stack calls would be O(N)O(N)O(N) one for each stone. Hence, the total space complexity would be O(N2)O(N^2)O(N 
2
 ). */
