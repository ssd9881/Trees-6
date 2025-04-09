// Tc:O(n)
// SC:O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
       
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr==null) sb.append('#');
            else{
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            } 
            sb.append(',');
        }
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0 || data.equals("#")) return null;
        
        String[] arr = data.split(",");
        if (arr[0].equals("#")) return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        
        int i = 1;
        while(!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            
            if(i < arr.length) {
                if(!arr[i].equals("#")) {
                    curr.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(curr.left);
                }
                i++;
            }
            
            if(i < arr.length) {
                if(!arr[i].equals("#")) {
                    curr.right = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(curr.right);
                }
                i++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));