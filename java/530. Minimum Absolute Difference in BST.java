/**
 *Problem: 530. Minimum Absolute Difference in BST
 *Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
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

    int min = Integer.MAX_VALUE;
    int prev = -10000000;

    public int getMinimumDifference(TreeNode root) {     
        if(root.left != null){
            getMinimumDifference(root.left);
        }
        min = Math.min(min, root.val-prev);
        prev = root.val;
        if(root.right != null){
            getMinimumDifference(root.right);
        } 

        return min;        
    }
}
