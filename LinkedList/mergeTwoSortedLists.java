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

        ListNode newList=new ListNode(0);
        ListNode curr=newList;
        
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                curr.next=list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        if(list1==null){
            curr.next=list2;
        }else if(list2==null){
            curr.next=list1;
        }
        return newList.next;
    }
}

// Just wooooow
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            if(l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else{
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
    }
}

// I dont know what solution is this, but it's definitely wrong
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