/**
 *Problem: 864. Shortest Path to Get All Keys
 *You are given an m x n grid grid where:

'.' is an empty cell.
'#' is a wall.
'@' is the starting point.
Lowercase letters represent keys.
Uppercase letters represent locks.
You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.

If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.

For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

Return the lowest number of moves to acquire all keys. If it is impossible, return -1.
 */

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        int allKeys = 0;
        int steps = 0;
        //{-1, 0} for up, {1, 0} for down, {0, -1} for left, and {0, 1} for right.
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<State> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[rows][cols][64]; // 3D array to track visited states

        // Find the initial position and count the total number of keys
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = grid[i].charAt(j);

                //(c - 'a'): This subtracts the ASCII value of the lowercase letter 'a' from the ASCII value of the character c. The purpose is to determine the position of the bit within the integer. For example, if c is the letter 'c', then c - 'a' would be equal to 2, representing the third bit (since 'a' is 0, 'b' is 1, and 'c' is 2).
//(1 << (c - 'a')): The bitwise left shift operator << is applied to the integer 1, shifting its binary representation to the left by the calculated number of positions. In this case, it shifts the binary 1 by (c - 'a') positions. For example, if (c - 'a') is 2, then (1 << (c - 'a')) would result in 4 (binary 100), effectively setting the third bit to 1. 

                if (c >= 'a') allKeys |= (1 << (c - 'a'));
                else if (c == '@') {
                    queue.offer(new State(i, j, 0));
                    visited[i][j][0] = true;
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                State currentState = queue.poll();
                
                // Explore in all the four directions
                for (int[] direction : directions) {
                    int newRow = currentState.row + direction[0];
                    if (direction[0] != 0 && (newRow < 0 || newRow >= rows)) continue;
                    int newCol = currentState.col + direction[1];
                    if (direction[1] != 0 && (newCol < 0 || newCol >= cols)) continue;
                    int newKeys = currentState.keys;
                    char newCell = grid[newRow].charAt(newCol);

                    // If the new position is a key, update the collected keys
                    if (newCell >= 'a') {
                        newKeys |= (1 << (newCell - 'a'));
                        if (newKeys == allKeys) return steps; // All keys found!
                    }
                    
                    // If the new position is a wall or a lock and we don't have the corresponding key, skip it
                    else if (newCell == '#' || newCell >= 'A' && (currentState.keys & (1 << (newCell - 'A'))) == 0) continue;

                    // Create a new state with the updated position and collected keys
                    if (!visited[newRow][newCol][newKeys]) {
                        queue.offer(new State(newRow, newCol, newKeys));
                        visited[newRow][newCol][newKeys] = true;
                    }
                }
            }
        }
        // If it's not possible to collect all keys
        return -1;
    }

    // Custom Class to represent the state of the grid
    private class State {
        int row;
        int col;
        int keys;

        public State(int row, int col, int keys) {
            this.row = row;
            this.col = col;
            this.keys = keys;
        }
    }
}
