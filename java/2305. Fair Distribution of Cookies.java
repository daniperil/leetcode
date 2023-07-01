/**
 *Problem: 2305. Fair Distribution of Cookies
 *You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag. You are also given an integer k that denotes the number of children to distribute all the bags of cookies to. All the cookies in the same bag must go to the same child and cannot be split up.
 *The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.
 *Return the minimum unfairness of all distributions.
 */

class Solution {

    int ans = Integer.MAX_VALUE;
    
    //start represents the index of the current cookie we are considering
    //temp is a reference to the vector that stores the current distribution of cookies among the children
    //k represents the number of children
    // ans is a reference to the variable that stores the minimum difference between the maximum and minimum number of cookies among the children. 
    void helper(int[] cookies, int start, int k , int[] temp){
        //Checks if we have processed all the cookies
        if(start == cookies.length){
            int max = 0;
            for(int c : temp)
                max = Math.max(max,c);
            ans = Math.min(ans,max);
            return;
        }
        for(int i = 0; i < k;i++){
            temp[i] += cookies[start];
            helper(cookies, start+1, k, temp);
            //This line performs backtracking. After the recursive call returns, we need to undo the changes made in step 1 to explore other possibilities. 
            temp[i] -= cookies[start];
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        helper(cookies, 0, k, new int[k]);
        return ans;        
    }
}
