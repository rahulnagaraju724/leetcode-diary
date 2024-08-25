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
    public ListNode removeZeroSumSublists(ListNode head) {
        //1171. Remove Zero Sum Consecutive Nodes from Linked List
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        for(int i=0;i<list.size();i++){
            int sum=0;
            //System.out.println("Outer loop:"+i);
            for(int j=i;j<list.size();j++){
                //System.out.println("Inner loop:"+j);
                sum+=list.get(j);
                if(sum==0){
                    //System.out.println("Inside sum=0, "+i+" "+j);
                    for(int value=j-i+1;value>0;value--){
                        //System.out.println("removing");
                        list.remove(i);
                    }
                    //System.out.print("ArrayList elements: " + list);
                    sum=0;
                    j=i-1;
                }
            }
        }

        //System.out.print("ArrayList elements: " + list);

        ListNode newHead=null;
        ListNode current=null;

        for(int element:list){
            ListNode newNode=new ListNode(element);
            if(newHead==null){
                newHead=newNode;
                current=newNode;
            }else{
                current.next=newNode;
                current=current.next;
            }
            
        }

        return newHead;

    }
}