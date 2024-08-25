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
    public ListNode reverseList(ListNode head) {
        // This is not working
        ListNode newHead=null;
        ListNode simple=reverseList(head,newHead);
        return newHead;
    }

    public ListNode reverseList(ListNode head, ListNode newHead){
        if(head.next==null){
            System.out.println(head.val);
            newHead=head;
            return head;
        }
        ListNode newHead2 = reverseList(head.next);
        System.out.println(newHead2);
        System.out.println(head.val);
        newHead2.next=head; // Error in this line - java.lang.NullPointerException: Cannot assign field "next" because "<local3>" is null
        head.next=null;
        return newHead2.next;// or we can return head
    }
}

// Both iterative and recursive solution
class Solution {
    public ListNode reverseList(ListNode head) {
        //206. Reverse Linked List
        //return reverseList(head, null);
        ListNode newHead=null;
        while(head!=null){
            ListNode nextNode=head.next;
            head.next=newHead;
            newHead=head;
            //head=head.next; This is wrong bcz head.next is null
            head=nextNode;
        }
        return newHead;
    }

    private ListNode reverseList(ListNode current, ListNode newHead) {
        if (current == null) {
            return newHead;
        }

        ListNode nextNode = current.next;
        current.next = newHead;
        return reverseList(nextNode, current);
    }
}


// My latest code
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode prev=head;
        ListNode curr=head.next;

        prev.next=null;

        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }
}

// More optimised one
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }
}

