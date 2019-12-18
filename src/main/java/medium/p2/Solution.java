package medium.p2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        return _addTwoNumbers(l1, l2, 0);
    }

    private ListNode _addTwoNumbers(ListNode l1, ListNode l2, int upgrade) {
        if(l1 == null && l2 == null && upgrade == 0){
            return null;
        }else {
            l1 = (l1 == null) ? new ListNode(0) : l1;
            l2 = (l2 == null) ? new ListNode(0) : l2;

            int tmp = l1.val + l2.val + upgrade;
            upgrade = tmp /10;
            tmp = tmp % 10;
            ListNode node = new ListNode(tmp);
            node.next = _addTwoNumbers(l1.next, l2.next, upgrade);
            return node;
        }
    }


    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args){

        int[] testData = {-2, 1, -5, 6};

        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(new ListNode(9), null);
        System.out.println(node);
    }
}

/**
 * Definition for singly-linked list.
 *  
 * */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
