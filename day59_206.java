class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;  // save next nodessssssss
            curr.next = prev;           // reverse kria link
            prev = curr;                //  prev forward nodeeeesss
            curr = next;                // curr forward nodessssss
        }
        
        return prev;  //prevvv is new head
    }
}