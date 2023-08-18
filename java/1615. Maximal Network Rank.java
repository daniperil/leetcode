/**
 *Problem: 1615. Maximal Network Rank
 *PThere is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.
 *The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.
 *The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
 *Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 */

public class Solution {
    //Degree Counting with Direct Connection Check
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degrees = new int[n];
        for (int[] road : roads) {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        
        Set<Integer> uniqueDegrees = new HashSet<>();
        for (int degree : degrees) {
            uniqueDegrees.add(degree);
        }
        
        List<Integer> sortedDegrees = new ArrayList<>(uniqueDegrees);
        Collections.sort(sortedDegrees, Collections.reverseOrder());

        int maxDeg = sortedDegrees.get(0);
        int secondMaxDeg = sortedDegrees.size() > 1 ? sortedDegrees.get(1) : 0;

        int maxCount = 0;
        for (int degree : degrees) {
            if (degree == maxDeg) maxCount++;
        }

        int secondMaxCount = 0;
        for (int degree : degrees) {
            if (degree == secondMaxDeg) secondMaxCount++;
        }

        if (maxCount > 1) {
            int directlyConnected = 0;
            for (int[] road : roads) {
                if (degrees[road[0]] == maxDeg && degrees[road[1]] == maxDeg)
                    directlyConnected++;
            }
            int possibleConnections = maxCount * (maxCount - 1) / 2;
            return possibleConnections == directlyConnected ? 2 * maxDeg - 1 : 2 * maxDeg;
        }

        int directConnectionsToSecond = 0;
        for (int[] road : roads) {
            if ((degrees[road[0]] == maxDeg && degrees[road[1]] == secondMaxDeg) ||
                (degrees[road[0]] == secondMaxDeg && degrees[road[1]] == maxDeg))
                directConnectionsToSecond++;
        }

        return secondMaxCount == directConnectionsToSecond ? maxDeg + secondMaxDeg - 1 : maxDeg + secondMaxDeg;
    }
}
/**
Complexity 2/2:
Time Complexity:

The solution has a time complexity of O(n+len(roads))O(n + \text{len(roads)})O(n+len(roads)). This is derived from counting degrees and checking direct connections among a few cities, rather than iterating over all pairs.
Space Complexity:

The space complexity is O(n+len(roads))O(n+\text{len(roads)})O(n+len(roads)). The degree list occupies O(n)O(n)O(n) space and the road set occupies O(len(roads))O(\text{len(roads)})O(len(roads)) space. */
