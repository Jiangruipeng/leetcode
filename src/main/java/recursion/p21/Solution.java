package recursion.p21;

import java.util.HashMap;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        return _mergeTwoLists( l1, l2);
        
        
    }

    private ListNode _mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if ( l2 == null) {
            return l1;
        }else {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 <= val2){
               l1.next = _mergeTwoLists(l1.next, l2);
               return l1;
            } else {
                l2.next = _mergeTwoLists(l1, l2.next);
                return l2;
            }
        }



    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
    }
}

class ListNode {

    public ListNode(){};
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
