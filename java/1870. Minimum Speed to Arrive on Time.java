/**
 *Problem: 1870. Minimum Speed to Arrive on Time
 *You are given a floating-point number hour, representing the amount of time you have to reach the office. To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.
 *Each train can only depart at an integer hour, so you may need to wait in between each train ride.
 *For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
 *Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time, or -1 if it is impossible to be on time.
 *Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.
 */

class Solution{
    //Binary search
    public double timeRequired(int[] dist, int speed){
        double time = 0.0;
        for(int i = 0; i<dist.length;i++){
            double t = (double) dist[i] / (double) speed;
            //Round off to the next integer, if not the last ride.
            //Math.ceil(double num) is a static method in the Math class that is used to round a double value to the next highest integer
            time += (i==dist.length -1 ? t : Math.ceil(t));
        }
        return time;
    }

    public int minSpeedOnTime(int[] dist, double hour){
        int left = 1;
        int right = 10000000;
        int minSpeed = -1;

        while(left <= right){
            int mid = (left + right)/2;

            //Move to the left half.
            if(timeRequired(dist, mid) <= hour){
                minSpeed = mid;
                right = mid - 1;
            }
            else{
                //Move to the right half.
                left = mid +1;
            }
        }
        return minSpeed;
    }
}
/**
Complexity Analysis

Here, N is the number of rides, and K is the size of the search space. For this problem, K is equal to 10^7 
7
 .

Time complexity: O(Nlog⁡K)

After each iteration, the search space gets reduced to half; hence the while loop will take log⁡K operations. For each such operation, we need to call the timeRequired function, which takes O(N) time. Therefore, the total time complexity equals O(Nlog⁡K).

Space complexity: O(1)

No extra space is required other than the three variables. Hence the space complexity is constant.
 */
