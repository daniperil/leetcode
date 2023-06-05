/**
 *Problem: 1672. Richest Customer Wealth
 *You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
 *A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
 */
 
class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = -1;

        for(int i = 0; i< accounts.length;i++){
            //You put x inside the first loop so that it restarts the sum for every cusotmer
            int x = 0;
            for(int j = 0; j< accounts[i].length; j++){
                x+=accounts[i][j];
            }
            maxWealth = Math.max(maxWealth,x);
        }
        return maxWealth;
    }
}
