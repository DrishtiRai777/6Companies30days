// https://leetcode.com/problems/combination-sum-iii/
class Solution {
    public void helper(int idx, int k, int target, List<List<Integer>> mainList, List<Integer> list) {
        // Base Case
        if(idx >= 9) {
            if(target == 0 && list.size() == k) 
                mainList.add(new ArrayList<>(list));
            return;
        } 

        // add 
        list.add(idx+1);
        helper(idx+1, k, target - (idx+1), mainList, list);

        // skip this element
        list.remove(list.size()-1);
        helper(idx+1, k, target, mainList, list);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> mainList = new ArrayList<>();
        // Edge Case
        if(n > 45) return mainList;

        helper(0, k, n, mainList, new ArrayList<>());

        return mainList;
    }
}
