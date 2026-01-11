class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        
        ListNode o = head, e = head.next, eHead = e;
        
        while (e != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        
        o.next = eHead;
        return head;
    }
}