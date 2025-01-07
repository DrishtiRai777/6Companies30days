// Problem: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("# ");
                continue;
            }

            sb.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        
        String values[] = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        
        q.add(root);

        for(int i=1; i<values.length; i++) {
            TreeNode curr = q.poll();

            if(!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                curr.left = left;
                q.add(left);
            }

            if(!values[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                curr.right = right;
                q.add(right);
            }
        }

        return root;
    }
}
