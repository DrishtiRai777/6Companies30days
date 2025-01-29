// https://leetcode.com/problems/merge-k-sorted-lists/
class Pair {
    int val;
    ListNode node;

    Pair(int val, ListNode node) {
        this.val = val;
        this.node = node;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.val - y.val);
        for(ListNode list: lists) {
            if(list != null)
                pq.add(new Pair(list.val, list));
        } 

        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            int val = p.val;
            ListNode node = p.node;

            // Create connection
            temp.next = node;
            if(node.next != null) 
                pq.add(new Pair(node.next.val, node.next));
            temp = temp.next;
        }

        return dummy.next;
    }
}
