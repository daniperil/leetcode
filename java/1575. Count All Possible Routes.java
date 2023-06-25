/**
 *Problem: 1575. Count All Possible Routes
 *You are given an array of distinct positive integers locations where locations[i] represents the position of city i. You are also given integers start, finish and fuel representing the starting city, ending city, and the initial amount of fuel you have, respectively.
 *At each step, if you are at city i, you can pick any city j such that j != i and 0 <= j < locations.length and move to city j. Moving from city i to city j reduces the amount of fuel you have by |locations[i] - locations[j]|. Please notice that |x| denotes the absolute value of x.
 *Notice that fuel cannot become negative at any point in time, and that you are allowed to visit any city more than once (including start and finish).
 *Return the count of all possible routes from start to finish. Since the answer may be too large, return it modulo 109 + 7.
 */

class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        int n = locations.length;
        int memo[][] = new int[n][fuel+1];

        for(int i = 0; i <n; i++){
            Arrays.fill(memo[i],-1);
        }

        return solve(locations, start, finish, fuel, memo);
        
    }

    public int solve(int[] locations, int currCity, int finish, int remainingFuel, int memo[][]){
            if(remainingFuel<0){
                return 0;
            }
            if(memo[currCity][remainingFuel] != -1){
                return memo[currCity][remainingFuel];
            }

            int ans = currCity == finish ? 1 : 0;
            for(int nextCity = 0; nextCity < locations.length; nextCity++){
                if(nextCity != currCity){
                    ans = (ans + solve(locations, nextCity, finish, remainingFuel-Math.abs(locations[currCity]-locations[nextCity]), memo)) % 1000000007;
                }
            }
            return memo[currCity][remainingFuel] = ans;
        }
}
