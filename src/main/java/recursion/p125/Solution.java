package recursion.p125;


class Solution {

    
    public boolean isPalindrome(String s) {
        //step1 keep only alphanumber chars
        String content = filterChar(s);
        //check if is palindrome
        return checkPalindrome(content);
    }
    
    private boolean checkPalindrome(String s){
        if (s.length() == 0 || s.length() == 1) { return true;}
        int start = 0;
        int end = s.length() -1 ;
        while (end > start) {
            char pair1 = s.charAt(start++);
            char pair2 = s.charAt(end--);
            if (pair1 != pair2) {
                return false;
            }
        }
        return true;
    }
  
    private String filterChar(String s){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((c >=48 && c <=57) || (c >=65 && c <=90) || (c >=97 && c <=122)){
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }


    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        String ret = solution.filterChar(test);
        System.out.println(solution.isPalindrome(test));
    }
}