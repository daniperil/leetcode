/**
 *Problem: 242. Valid Anagram
 *Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hash = new HashMap<>();

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        boolean resp = false;

        for(char c : arr1){
            hash.put(c, hash.getOrDefault(c,0)+1);
        }

        for (char c : arr2) {
            if (!hash.containsKey(c) || hash.get(c) == 0) {
                return resp; 
            } else {
                hash.put(c, hash.get(c) - 1);
            }
        }

        for (Integer value : hash.values()) {
            if (value != 0) {
                return false;
            }
        }

        resp = true;
        return resp;        
    }
}
