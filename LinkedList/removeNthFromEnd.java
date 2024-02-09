// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        
        ListNode returnHead=head;
        ListNode pointer=head;
        int i=0;

        while(pointer.next!=null && i!=n){
            pointer=pointer.next;
            i++;
        }

        while(pointer.next!=null){
            head=head.next;
            pointer=pointer.next;
        }
        
        ListNode dummy=head.next;
        if(dummy==null){
            System.out.println("Dummy is null");
        }
        System.out.println(dummy.val);
        return returnHead;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            System.out.println("The list is empty");
            return null;
        }

        ListNode pointer = head;
        int i = 0;

        // Move 'pointer' n nodes ahead
        while (i < n && pointer != null) {
            pointer = pointer.next;
            i++;
        }

        // If 'pointer' became null before reaching the n-th node, handle it accordingly
        if (i < n || pointer == null) {
            System.out.println("The list is shorter than " + n + " nodes");
            return null;
        }

        // Move 'head' and 'pointer' until 'pointer' reaches the end
        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }

        System.out.println(head.val);
        return head;
    }
}
