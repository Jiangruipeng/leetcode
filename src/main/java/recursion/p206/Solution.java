package recursion.p206;

import java.util.ArrayList;
import java.util.List;

//         i
//1->2->3->4->5->null
//         i
//5->1->2->3->4->null

public class Solution {
  
    public ListNode reverseList(ListNode head) {

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        //step1 move tail to head
        ListNode secondLast = head;
        while(secondLast.next.next !=  null) {
            secondLast = secondLast.next;
        }
        ListNode tail = secondLast.next;
        secondLast.next = null;
        //step2 reverse the subList
        
        //step3 the new head link the reversed subList
        tail.next = reverse(head);
        return tail;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
