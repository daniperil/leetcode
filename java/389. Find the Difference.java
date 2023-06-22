/**
 *Problem: 389. Find the Difference
 *You are given two strings s and t.
 *String t is generated by random shuffling string s and then add one more letter at a random position.
 *Return the letter that was added to t.
 */

class Solution {
    public char findTheDifference(String s, String t) {

        Map<Character, Integer> charCount = new HashMap<>();

        char resp = '\0';

        //Puts characters of string s in Map
        //Map.getOrDefault(): Retrieves the value associated with a specified key from the map. If the key is present in the map, it returns the corresponding value. If the key is not found in the map, it returns a default value provided as the second argument to getOrDefault().
        
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        //Withdraws the letters of the letter sn and finds the different letter.
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                resp = c; 
            } else {
                charCount.put(c, charCount.get(c) - 1);
            }
         }
         return resp;
    }
}