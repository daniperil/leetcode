/**
 *Problem: 767. Reorganize String
 *Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 *Return any possible rearrangement of s or return "" if not possible.
 */

public class Solution {
    //Array Sort Approach
    public String reorganizeString(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        //A PriorityQueue named maxHeap is created. The queue is sorted in a way that the characters with the highest frequency appear at the front. This is achieved by using a comparator that compares characters based on their frequencies in the freqMap. The queue is populated with the keys (characters) from the freqMap.
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        //This code snippet checks whether it's possible to reorganize the string as required. If the frequency of the most frequent character is greater than half the length of the string (rounded up), then it's impossible to reorganize the string without having adjacent characters being the same. In this case, an empty string is returned.
        if (freqMap.get(maxHeap.peek()) > (s.length() + 1) / 2) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        char[] result = new char[s.length()];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            for (int j = 0; j < freqMap.get(c); j++) {
                if (i >= s.length()) i = 1;
                result[i] = c;
                i += 2;
            }
        }

        return new String(result);
    }
}
/**
Time Complexity:
Array Sort Approach: O(n+klog⁡k)O(n + k \log k)O(n+klogk)

O(n)O(n)O(n) for counting the frequency of each character in the string.
O(klog⁡k)O(k \log k)O(klogk) for sorting the unique characters by their frequency.
O(n)O(n)O(n) for placing the characters into the new string. Here, you iterate through each character, inserting them into their respective places in the result string.
Space Complexity:
O(n)O(n)O(n)
In the Array Sort Approach, the sorted array and result string would also contain nnn characters. */
