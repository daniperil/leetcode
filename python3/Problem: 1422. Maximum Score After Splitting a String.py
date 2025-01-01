'''
Problem: 1422. Maximum Score After Splitting a String
Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
'''
class Solution(object):
    def maxScore(self, s):
        totalOnes = s.count('1') #Total count of 1s in the entire string s
        zerosCount = 0
        onesCount = 0
        bestScore = float('-inf') #Holds the highest score found so far. It is initialized to negative infinity to ensure any calculated score will be larger.

        #Traverse the string and calculate scores
        for i in range(len(s)-1): #Stop before the last character
            if s[i]=='0':
                zerosCount+=1
            else:
                onesCount+=1
            
            #Calculate score
            currentScore = zerosCount+(totalOnes-onesCount)
            bestScore = max(bestScore, currentScore)
        
        return bestScore
        
