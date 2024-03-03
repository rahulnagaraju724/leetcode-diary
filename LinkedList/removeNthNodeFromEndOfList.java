/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //19. Remove Nth Node From End of List
        ListNode fast=head;
        int i=0;
        while(i<n && fast.next!=null){
            fast=fast.next;
            i++;
        }

        if(fast.next==null && i!=n){ //i!=n V.V.V. IMP, means remove first node bcz fast has not travelled n times
            ListNode newHead=head.next;
            head.next=null;
            return newHead;
        }

        ListNode slow=head;

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        ListNode deleteNode=slow.next;
        slow.next=slow.next.next;
        deleteNode.next=null;

        return head;
        
    }
}


