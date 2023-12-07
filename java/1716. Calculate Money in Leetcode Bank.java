/**
 *Problem: 1716. Calculate Money in Leetcode Bank
 *Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

 *He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
 *Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
 */

class Solution {
    public int totalMoney(int n) {
        int week_count = n / 7;
        //week_count: number of complete weeks
        int remaining_days = n % 7;
        //remaining_days: remaining days
        
        int total = ((week_count * (week_count - 1)) / 2) * 7; // Contribution from complete weeks (each new complete week contributes 7 more to the total)
        total += week_count * 28; // Contribution from complete weeks (additional on Mondays)
        total += ((remaining_days * (remaining_days + 1)) / 2) + (week_count * remaining_days); // Contribution from remaining days
        
        return total;
    }
}
