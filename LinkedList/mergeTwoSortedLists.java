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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //21. Merge Two Sorted Lists
        if(list2==null){
            return list1;
        }else if(list1==null){
            return list2;
        }

        ListNode head=null;
        ListNode newList=null;

        while(list1!=null || list2!=null){
            ListNode newNode=null;
            if(list1.val<=list2.val){
                newNode=new ListNode(list1.val);
                if(head==null){
                    head=newNode;
                    newList=head;
                }
                else{
                    newList.next=newNode;
                }
                newList=newList.next;
                list1=list1.next;
            }else{
                newNode=new ListNode(list2.val);
                if(head==null){
                    head=newNode;
                    newList=head;
                }
                else{
                    newList.next=newNode;
                }
                newList=newList.next;  
                list2=list2.next;              
            }
        }

        if(list1==null){
            ListNode newNode=null;
            while(list2!=null){
                newNode=new ListNode(list2.val);
                newList.next=newNode;
                newList=newList.next;
                list2=list2.next;
            }
        }
        else if (list2==null){
            ListNode newNode=null;
            while(list1!=null){
                newNode=new ListNode(list1.val);
                newList.next=newNode;
                newList=newList.next;
                list1=list1.next;
            }
        }

        return head;
    
    }
}