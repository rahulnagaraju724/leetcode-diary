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
    public ListNode swapPairs(ListNode head) {
        //24. Swap Nodes in Pairs
        System.out.println("new propblem");
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode current;
        ListNode swap;
        ListNode nextHead=head;

        ListNode prev=null;//needed

        head=null;

        while(nextHead!=null && nextHead.next!=null){
            System.out.println("nextHead: "+nextHead.val);
            current=nextHead;
            swap=current.next;
            nextHead=swap.next;

            if(head==null){
                head=swap;
            }

            if(prev!=null){ // needed
                prev.next=swap;
            }

            swap.next=current;
            current.next=nextHead;
            prev=current; // must need // otherwise 2,1,3 will come
            System.out.println("nextHead: "+nextHead);
        }
        return head;
    }
}

