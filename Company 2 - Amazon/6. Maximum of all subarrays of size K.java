// Problem: https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
class Solution {
    public ArrayList<Integer> max_of_subarrays(int nums[], int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0; i<nums.length; i++) {
            if(!dq.isEmpty() && dq.getFirst() <= i-k) // out of the window...remove from dq
                dq.removeFirst();
                
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) // curr ele >= dq.last
                dq.removeLast();
            
            dq.addLast(i); // add curr ele
            
            if(i >= k-1) 
                list.add(nums[dq.getFirst()]);
        }
        
        return list;
    }
}
