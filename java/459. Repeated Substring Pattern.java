/**
 *Problem: 459. Repeated Substring Pattern
 *Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 */

class Solution {
    public boolean repeatedSubstringPattern(String str) {

    //This method consists of analyzing the half of the original str and the Strings derived from withdrawing a letter from the half of the original String, and the expand it x times so that it matches the size of the original string and then compares it.
        
	int l = str.length();
	for(int i=l/2;i>=1;i--) {
		if(l%i==0) {
			int m = l/i;

            //The substring() method returns a new string that consists of the characters starting from index 0 (inclusive) up to index i (exclusive).

			String subS = str.substring(0,i);
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<m;j++) {
				sb.append(subS);
			}
			if(sb.toString().equals(str)) return true;
		}
	}
	return false;
    }

}
