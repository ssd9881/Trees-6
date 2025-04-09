// tc:O(n)
//sc:O(n)
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        TreeMap<Integer, List<int[]>> colMap = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0});
        
        while (!queue.isEmpty()) {
            Object[] current = queue.poll();
            TreeNode node = (TreeNode) current[0];
            int col = (int) current[1];
            int row = (int) current[2];
            
            if (!colMap.containsKey(col)) {
                colMap.put(col, new ArrayList<>());
            }
            colMap.get(col).add(new int[]{row, node.val});
            
            if (node.left != null) {
                queue.offer(new Object[]{node.left, col - 1, row + 1});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, col + 1, row + 1});
            }
        }
        
        for (Map.Entry<Integer, List<int[]>> entry : colMap.entrySet()) {
            List<int[]> colNodes = entry.getValue();
            
            Collections.sort(colNodes, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0]; 
                }
                return a[1] - b[1]; 
            });
            
            List<Integer> sortedCol = new ArrayList<>();
            for (int[] node : colNodes) {
                sortedCol.add(node[1]);
            }
            
            result.add(sortedCol);
        }
        
        return result;
    }
}