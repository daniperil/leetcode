/**
 *Problem: 383. Ransom Note
 *Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *Each letter in magazine can only be used once in ransomNote.
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean resp = true;
        if (ransomNote.length() > magazine.length()){
            resp = false;
            return resp;
        }

        HashMap<Character, Integer> map = new HashMap<>();

       for(int i=0;i<magazine.length();i++){
            if(map.containsKey(magazine.charAt(i))) 
                map.put(magazine.charAt(i), map.get(magazine.charAt(i))+1);
            else map.put(magazine.charAt(i),1);
        }

        for(int i=0;i<ransomNote.length();i++){
            if(map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i))>0){
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
            }else{
                resp = false;
            }
        }

        return resp;
        
    }
}
