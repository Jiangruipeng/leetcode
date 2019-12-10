package recursion.p344;

class Solution {
    public void reverseString(char[] s) {
        if(s.length == 0) {
            return;
        }
        helper(s.length -1, s);
    }
    
    public void helper(int index, char[] s){
        
        if(index == 0 ) {
            return;
        }
        char c = s[0];
        System.arraycopy(s, 1, s, 0, index);
        s[index] = c;
        System.out.println(s);

        helper(index-1, s);
    }


    public static void main(String[] args){
        char[] data = {'h','e','l','l','o'};
        Solution solution = new Solution();
        solution.reverseString(data);

    }
}