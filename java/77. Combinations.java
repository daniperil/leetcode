/**
 *Problem: 77. Combinations
 *Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *You may return the answer in any order.
 */

class Solution {
    //Backtracking
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(1, n, k, new ArrayList<Integer>(), result);
        return result;
    }

    public void generateCombinations(int start, int n, int k, List<Integer> combination, List<List<Integer>> result){
        if(k==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i = start; i <= n-k+1;i++){
            combination.add(i);
            generateCombinations(i+1, n, k-1, combination, result);
            combination.remove(combination.size()-1);
        }
    }
}
