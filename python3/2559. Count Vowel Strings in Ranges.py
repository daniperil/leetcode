'''
Problem: 2559. Count Vowel Strings in Ranges
You are given a 0-indexed array of strings words and a 2D array of integers queries.
Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.
Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.
'''

class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        prefix = [0]
        cur = 0
        vowelSet = set(['a', 'e', 'i', 'o', 'u'])
        for s in words:
            if s[0] in vowelSet and s[-1] in vowelSet:
                cur += 1
            prefix.append(cur)
        res = []
        for s, e in queries:
            res.append(prefix[e+1] - prefix[s])
        return res
