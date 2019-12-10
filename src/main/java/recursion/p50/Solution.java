package recursion.p50;

import java.util.HashMap;

public class Solution {

    public double myPow(double x, int n) {
        if (n >=0) {
            return _myPow(x,n);
        } else {
            return 1.0/_myPow(x,Math.abs((long)n));
        }
    }

    private double _myPow(double x, long n) {
        if (n == 1) {
            return x;
        }else if (n == 0){
            return 1;
        }

        if (n % 2 == 0) {
            return _myPow (x*x, n/2);
        } else {
            return x * _myPow(x*x, (n-1)/2);
        }
    }

   
    public double myPow2(double x, int n) {
        if (n >=0) {
            return _myPow2(x,n);
        } else {
            return 1.0/_myPow2(x,-n);
        }
    }

    private double _myPow2(double x, int n) {
        double ret = 1;
        for (int i=0; i < n; i++) {
            ret = ret * x;
        }
        return ret;
    }
    

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(0-Integer.MIN_VALUE);
        System.out.println(solution.myPow(1.0000,-2147483648));
        //System.out.println(solution.myPow(3,-2));
        
    }
}

