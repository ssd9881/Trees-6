// tc:O(n)
// sc:O(h)
// 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int result=0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(low<=curr.val && curr.val<=high){
                result+=curr.val;
            }
            if(curr.val>=low && curr.left!=null){
                q.add(curr.left);
            }
            if(curr.val<=high && curr.right!=null){
                q.add(curr.right);
            }
        }
        return result;
    }
}