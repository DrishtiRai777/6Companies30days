// Problem: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
class Pair {
    TreeNode node;
    int time;

    Pair(TreeNode node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public void parentPointer(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
                map.put(node.left, node);
            }

            if (node.right != null) {
                q.offer(node.right);
                map.put(node.right, node);
            }
        }
    }

    public TreeNode findNode(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;

        TreeNode left = findNode(root.left, start);
        TreeNode right = findNode(root.right, start);

        return left == null ? right : left;
    }

    public int amountOfTime(TreeNode root, int start) {
        // Base Case
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        // Parent Pointer Map
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        parentPointer(root, map);

        // Visited map..
        HashMap<TreeNode, Boolean> vis = new HashMap<>();

        // Find the node ...
        TreeNode st = findNode(root, start);

        // Level Order
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(st, 0));
        vis.put(st, true);
        int maxTime = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.poll();
                TreeNode node = p.node;
                int time = p.time;

                maxTime = Math.max(time, maxTime);

                // left child;
                if (node.left != null && vis.containsKey(node.left) == false) {
                    q.offer(new Pair(node.left, time + 1));
                    vis.put(node.left, true);
                }

                // right child;
                if (node.right != null && vis.containsKey(node.right) == false) {
                    q.offer(new Pair(node.right, time + 1));
                    vis.put(node.right, true);
                }

                // Parent;
                if (map.get(node) != null && vis.containsKey(map.get(node)) == false) {
                    q.offer(new Pair(map.get(node), time + 1));
                    vis.put(map.get(node), true);
                }
            }
        }

        return maxTime;
    }
}
