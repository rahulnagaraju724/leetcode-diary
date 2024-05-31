/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //237. Delete Node in a Linked List
        node.val=node.next.val;   // Delete node wont be last node
        node.next=node.next.next;
    }
}