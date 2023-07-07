/**
 *Problem: 2024. Maximize the Confusion of an Exam
 *A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
 *You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
 *Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
 *Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
 */

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        //Advanced Sliding Window
        int maxSize = 0;
        Map<Character, Integer> count = new HashMap<>();

        for(int right = 0; right < answerKey.length(); right++){
            count.put(answerKey.charAt(right),count.getOrDefault(answerKey.charAt(right),0)+1);
            int minor = Math.min(count.getOrDefault('T',0), count.getOrDefault('F',0));

            if(minor<=k){
                maxSize++;
            }
            else{
                count.put(answerKey.charAt(right - maxSize), count.get(answerKey.charAt(right - maxSize)) - 1);
            }
        }
        return maxSize;
    }
}
