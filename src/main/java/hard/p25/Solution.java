package hard.p25;

import java.util.ArrayList;
import java.util.List;

//         i
//1->2->3->4->5->null
//         i
//5->1->2->3->4->null

public class Solution {
  
    public ListNode reverseKGroup(ListNode head, int k) {
        //head is null
        if(head == null){
            return null;
        }
        if (k == 1){
            return head;
        }

        int length = 1;
        ListNode subProblem = head;

        while (length< k && subProblem != null){
            length++;
            subProblem= subProblem.next;
        }
        if (length == k && subProblem != null){
            //found
            ListNode nextHead = subProblem.next;
            //split two lists
            subProblem.next = null;
            ListNode firstlist =reverse(head);
            ListNode secondlist = reverseKGroup(nextHead, k);
            //append two lists
            return append(firstlist, secondlist);
        }else{
            //do nothing
            //no need to reverse
            return head;
        }
        
    }

    private ListNode append(ListNode first, ListNode second){
        //find the first tail
        ListNode current = first;
        while(current.next!= null){
            current = current.next;
        }
        current.next = second;
        return first;
    }


    /**
     * reverse list
     * @param head
     * @return
     */
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
