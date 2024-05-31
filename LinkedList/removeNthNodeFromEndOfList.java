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
        if(head==null){
            return null;
        }

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

        slow.next=slow.next.next; // Main thing is this

        deleteNode.next=null;

        return head;
        
    }
}

//n=3, remove 8, I have to stop at 7, so at last node, 
//a link must be pointing to before node 8, means here at node 7
//1 2 3 4 5 6 7  8 9  10



class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next; // Move the fast pointer N nodes ahead
        if (fast == null) return head.next;//// If fast becomes null, the Nth node from the end is the head
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp, second = temp;

        while (n > 0) {
            second = second.next;
            n--;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;
        return temp.next;
    }
}