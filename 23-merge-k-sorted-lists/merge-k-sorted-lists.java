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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        int n = lists.length;
        if(n == 0)
        {
            return null;
        }
        for(int i=0;i<n;i++)
        {
            if(lists[i] != null)pq.offer(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(pq.size() > 0)
        {
            ListNode curr = pq.poll();
            temp.next = new ListNode(curr.val);
            if(curr.next != null){
                curr = curr.next;
                 pq.offer(curr);
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}