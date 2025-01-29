// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
class Data {
    int sum;
    int max;
    int min;
    boolean isBST;

    Data(int sum, int max, int min, boolean isBST) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.isBST = isBST;
    }
}

class Solution {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        if(root == null) return maxSum;
        if(root.left == null && root.right == null) return Math.max(maxSum, root.val);
        Data data = helper(root);
        return maxSum;
    }

    public Data helper(TreeNode root) {
        // Base Case
        if (root == null) 
            return new Data(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        
        Data dLeft = helper(root.left); // go left
        Data dRight = helper(root.right); // go right

        if(dLeft.isBST && dRight.isBST && dLeft.max < root.val && dRight.min > root.val) {
            int sum = dLeft.sum + dRight.sum + root.val;
            maxSum = Math.max(sum, maxSum);
            int min = Math.min(dLeft.min, root.val);
            int max = Math.max(dRight.max, root.val);
            return new Data (sum, max, min, true);
        }
        return new Data (0, 0, 0, false);
    }
}
