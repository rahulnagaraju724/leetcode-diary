/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //141. Linked List Cycle
        HashSet<ListNode> set=new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return true;
            }
            else{
                set.add(head);
            }
            head=head.next;
        }
        return false;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null){
            return false;
        }
        ListNode fast=head.next;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            if(slow==fast){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        return false;

    }
}