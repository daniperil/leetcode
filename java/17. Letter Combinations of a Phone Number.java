/**
 *Problem: 17. Letter Combinations of a Phone Number
 *Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        //Backtracking
        if(digits.isEmpty()) return Collections.emptyList();

        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> resp = new ArrayList<>();
        backtrack("", digits, phone_map, resp);
        return resp;
    }

    public void backtrack(String combination, String next_digits, String[] phone_map, List<String> resp){
        if(next_digits.isEmpty()){
            resp.add(combination);
        }
        else{
            String letters = phone_map[next_digits.charAt(0) - '2'];
            for(char letter :letters.toCharArray()){
                //next_digist.substring(1) is a method call that returns a new string that is a substring of the original next_digits string, starting from index 1 to the end of the string.
                //next_digits: "234"
//next_digits.substring(1): "34"
                backtrack(combination+letter, next_digits.substring(1), phone_map, resp);
            }
        }
    }
}

/**
Complexity
Time complexity: ( O(4^n) ), where ( n ) is the length of the input string. In the worst case, each digit can represent 4 letters, so there will be 4 recursive calls for each digit.
Space complexity: ( O(n) ), where ( n ) is the length of the input string. This accounts for the recursion stack space. */
