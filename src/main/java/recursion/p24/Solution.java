package recursion.p24;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return swap(null, head);
        
    }
    
    public ListNode swap(ListNode previous, ListNode current){
        if(current == null){
            return null;
        }
        ListNode first = current;
        ListNode second = current.next;
        
        if(previous != null){
            previous.next = second;
        }
        if(first != null && second != null){
            ListNode tmp = second.next;
            second.next = first;
            first.next = tmp;
        }
        
        
        swap(first, first.next);
        return second;
        
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}