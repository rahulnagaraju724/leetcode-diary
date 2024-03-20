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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //1669. Merge In Between Linked Lists
        if(list1==null){
            return list1;
        }

        ListNode prev=null;
        ListNode curr=list1;

        ListNode aNodePrev=null;
        ListNode bNode=null;

        int counter=0;
        //boolean exit=false;

        while(curr.next!=null ){ //&& !exit
            prev=curr;
            curr=curr.next;
            counter++;
            if(counter==a){
                aNodePrev=prev;
            }
            if(counter==b){
                bNode=curr;
                //exit=true;
                break;
            }
        }

        if(list2==null){
            aNodePrev.next=bNode.next;
            bNode.next=null;
            return list1;
        }


        ListNode list2Last=list2;

        while(list2Last.next!=null){
            list2Last=list2Last.next;
        }

        aNodePrev.next=list2;
        list2Last.next=bNode.next;
        bNode.next=null;

        return list1;
    }
}

// Best approach

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left = list1;
        for (int i = 1; i < a; i++)
            left = left.next;
        
        ListNode middle = left;
        for (int i = a; i <= b; i++)
            middle = middle.next;
        
		left.next = list2;
        while (list2.next != null)
            list2 = list2.next;
        
        list2.next = middle.next;
        return list1;
    }
}