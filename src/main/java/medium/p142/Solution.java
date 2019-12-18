package medium.p142;

import java.util.HashMap;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    HashMap<ListNode, Integer> cache = new HashMap<ListNode, Integer>();

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        cache.put(head, 0);
        int idx = 1;

        ListNode  current = head;
        while(current.next != null){
            ListNode next = current.next;
            Integer pos = cache.get(next);
            if(pos == null){
                cache.put(next, idx);
            }else{
                //cycle found
                return next;
            }
            idx++;
            current=next;
        }
        return null;
    
    }

       
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}