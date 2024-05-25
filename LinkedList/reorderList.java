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
    public void reorderList(ListNode head) {
        //143. Reorder List
        if(head==null){
            return;
        }
        // First find mid
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode savedSlow=slow;

        // Then reverse the list from mid
        ListNode reversedList=null;
        ListNode nextNode=null;
        // slow=slow.next; //Not needed, was trying for workaround
        while(slow!=null){
            nextNode=slow.next;
            slow.next=reversedList;
            reversedList=slow;
            slow=nextNode;
        }
        // in. 1,2,3,4 -> only 4,4 is reversed List
        // but in. 1,2,3,4,5 -> it's 5,4,3

        // so I made changes as slow=slow.enxt before while check, 
        // rolled back

        ListNode curr=head;
        ListNode nextCurr=null;
        ListNode nextReverseList=null;
        while(curr!=savedSlow){
            // added && reversedList!=null as I made changes and skipping middle using slow=sloe.next
            // rolled back
            nextCurr=curr.next;

            // System.out.println(curr.val);
            // System.out.println(" -> "+reversedList.val);
            // System.out.println("nextCurr -> "+nextCurr.val);

            curr.next=reversedList;
            nextReverseList=reversedList.next;
            reversedList.next=nextCurr;
            reversedList=nextReverseList;
            curr=nextCurr;
        }



        curr.next=null;
        //return head;
    }
}

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

    public void reorderList(ListNode head) {
        
        //Find middle of list using a slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the second half of the list using a tmp variable
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        //Re-assign the pointers to match the pattern
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
