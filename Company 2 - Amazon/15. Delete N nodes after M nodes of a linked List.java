// Problem: https://www.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1
class Solution {
    static void linkdelete(Node head, int n, int m) {
        Node temp = head;
        while(temp != null) {
            // Skip nodes
            for(int i=1; i<m && temp != null; i++) {
                temp = temp.next;
            }
            
            if(temp == null) return;
            
            // Count nodes to be deleted
            Node temp2 = temp.next;
            for(int i=0; i<n && temp2 != null; i++) {
                temp2 = temp2.next;
            }
            
            // Delete
            temp.next = temp2;
            // Reset temp
            temp = temp.next;
        }
    }
}
