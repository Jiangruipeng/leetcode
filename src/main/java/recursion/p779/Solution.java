package recursion.p779;

import java.util.HashMap;

public class Solution {

    /**
     * F(N,K) = 1 - F(N-1, K/2)    if (K %2 == 0)
     * F(N,K) = F(N-1, (K+1)/2)    if (K %2 == 1)
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar(int N, int K) {
        if (N == 0){
            return 0;
        }

        if ( K %2 == 0) {
            return 1 - kthGrammar(N-1, K/2);
        } else {
            return kthGrammar(N-1, (K+1)/2);
        }

    }  

    public static void main(String[] args) {
        Solution solution = new Solution();
        
    }
}

