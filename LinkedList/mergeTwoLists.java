class Solution {
    // 21. Merge Two Sorted Lists

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode copyRes = new ListNode();
        ListNode res = copyRes;
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                res.next = list1;
                // System.out.println("l1 : " + list1.val);
                list1 = list1.next;
            } else {
                res.next = list2;
                // System.out.println("l2 : " + list2.val);
                list2 = list2.next;
            }
            res = res.next;
        }

        while (list1 != null) {
            res.next = list1;
            // System.out.println("l11 " + list1.val);
            list1 = list1.next;
            res=res.next;

        }

        while (list2 != null) {
            res.next = list2;
            // System.out.println("l22 " + list2.val);
            list2 = list2.next;
            res=res.next;

        }

        return copyRes.next;

    }
}