/**
 *Problem: 2707. Extra Characters in a String
 *You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.
 *Return the minimum number of extra characters left over if you break up s optimally.
 */

//Dynamic Programming with Trie data structure
    //A Trie (pronounced "try") is a tree-like data structure that is used for efficiently storing a dynamic set of strings or keys where the keys are usually sequences of characters. Tries are particularly useful for tasks involving dictionary-based search and retrieval operations, such as autocomplete suggestions, spell checking, and IP routing.

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = buildTrie(dictionary);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;  // No extra character for an empty string

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;  // Initialize with the worst-case scenario
            TrieNode node = root;
            for (int end = start; end < n; end++) {
                char ch = s.charAt(end);
                if (!node.children.containsKey(ch)) {
                    break;
                }
                node = node.children.get(ch);
                if (node.isWord) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }

    public TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.isWord = true;
        }
        return root;
    }
}


/**
Complexity Analysis
Time Complexity: O(n×m)O(n \times m)O(n×m)
nnn is the length of the string s, and mmm is the maximum length of a word in the dictionary. This complexity is because we traverse the Trie for each starting index in s.

Space Complexity: O(n+k)O(n + k)O(n+k)
nnn is the length of the string s, and kkk is the total number of characters in the Trie (dictionary). */
