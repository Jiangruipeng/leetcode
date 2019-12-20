package easy.p242;

import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(s.length() == 0 && t.length() == 0){
            return true;
        }
        int[] arrS = new int[26];
        int[] arrT = new int[26];

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            arrS[c -97]++;
        }
        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            arrT[c-97]++;
        }
     
        for (int i = 0; i < arrS.length; i++){
            if(arrS[i] != arrT[i]){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
       boolean b = s.isAnagram("ab", "ba");
       System.out.println(b);
    }
}