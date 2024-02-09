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

// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         // 2. Add Two Numbers - Not a good solution
//         int number1=getNumber(l1);
//         int number2=getNumber(l2);
//         //System.out.println(number1+" "+number2);
//         int finalNumber=number1+number2;

//         //LinkedList<ListNode> resultList=new LinkedList<>();
//         ListNode dummyNode=new ListNode(0);
//         ListNode resultList=dummyNode;
//         if(finalNumber==0){
//             return resultList;
//         }
//         while(finalNumber>0){
//             int temp=finalNumber%10;
//             finalNumber/=10;

//             // ListNode tempNode=new ListNode(temp);
//             // if(resultList.head==null){
//             //     resultList.head=tempNode;
//             // }
//             // else{
//             //     ListNode last=resultList.head;
//             //     while(last.next!=null){
//             //         last=last.next;
//             //     }
//             //     last.next=tempNode;
//             // }

//             ListNode newNode=new ListNode(temp);
//             resultList.next=newNode;
//             resultList=resultList.next;
//         }


//         return dummyNode.next;
//     }

//     public int getNumber(ListNode l){
//         int number=0;
//         int multiplier=1;
//         while(l!=null){
//             int temp=l.val * multiplier;
//             multiplier*=10;
//             number+=temp;
//             l=l.next;
//         }

//         return number;
//     }
// }


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}