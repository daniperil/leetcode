/**
 *Problem: 111. Minimum Depth of Binary Tree
 *Given a binary tree, find its minimum depth.
 *The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *Note: A leaf is a node with no children.
 */

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
    public int minDepth(TreeNode root) {

        //To do BFS you always have to create a queue to put its children

        if(root == null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while(q.isEmpty() == false){
            int qSize = q.size();

            while(qSize > 0){
                qSize--;

                TreeNode node = q.remove();
                //Since we added nodes without checking null, we need to skip them here.
                if(node == null){
                    continue;
                }

                //The first leaf would be at minimum depth, hence return it. 
                if(node.left == null && node.right== null){
                    return depth;
                }

                q.add(node.left);
                q.add(node.right);
            }
            depth++;
        }
        return -1;
        
    }
}
