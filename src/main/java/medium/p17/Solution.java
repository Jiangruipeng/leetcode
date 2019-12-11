package medium.p17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    private HashMap<Character, char[]> map = new  HashMap<Character, char[]>();
    public List<String> letterCombinations(String digits) {
        init();
        char[] result = new char[digits.length()];
        List<String> resultList = new ArrayList<String>();

        if(digits == null || digits.length() == 0){
            return resultList;
        }
        _letterCombinations( digits, result, resultList, 0);
        return resultList;
    }

    private void _letterCombinations(String digits, char[] result,  List<String> resultList,int start){
        char c = digits.charAt(start);
        char[] charArr = map.get(c);
        for (int i =0; i <charArr.length; i++){
            //place char
            result[start] = charArr[i];
            if(start == digits.length() -1){
                //reach the end 
                //found solution
                resultList.add(new String(result));
            }else{
                // sub problem
                _letterCombinations(digits, result, resultList, start+1);
            }

            //remove char
            //no need
        }
    }


    private void init(){
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'q','p','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
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
        List<String> ret = solution.letterCombinations("2");
        System.out.println(ret);
    }
}