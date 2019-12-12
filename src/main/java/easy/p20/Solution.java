package easy.p20;

import java.util.Stack;

class Solution {

    private String left = "([{";
    private String right = ")]}";


    public boolean isValid(String s) {

        boolean ret = true;
        if(s.length() %2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (left.indexOf(c) != -1){
                //is left
                stack.push(c);
            }else if (right.indexOf(c) != -1){
                //is right
                if(stack.size()<1){
                    return false;
                }
                char cl = stack.pop();
                int indexLeft = left.indexOf(cl);
                int indexRight = right.indexOf(c);
                if (indexLeft != indexRight){
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.size() == 0;
    }

    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = {-2, 1, -5, 6};

        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("(("));
        System.out.println(solution.isValid("){"));


        
    }
}