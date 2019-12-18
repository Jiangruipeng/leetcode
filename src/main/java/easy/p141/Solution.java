package easy.p141;

import java.util.HashMap;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    HashMap<ListNode, Integer> cache = new HashMap<ListNode, Integer>();
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        int idx = 1;
        ListNode  current = head;
        while(current.next != null){
            ListNode next = current.next;
            Integer pos = cache.get(next);
            if(pos == null){
                cache.put(next, idx);
            }else{
                //cycle found
                return true;
            }
            idx++;
            current=next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}