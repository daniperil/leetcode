/**
 *Problem: 94. Binary Tree Inorder Traversal
 *Given the root of a binary tree, return the inorder traversal of its nodes' values.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
}

/**
Complexity
Time Complexity: O(n), where n is the number of nodes in the binary tree. We visit each node once.
Space Complexity: O(h), where h is the height of the binary tree. The space is used for the recursive call stack, and in the worst case (skewed tree), it's O(n). In the average case (balanced tree), it's O(log n
                                                                                                                                                                                                              */
