/**
 *Problem: 606. Construct String from Binary Tree
 *Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.
 *Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
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
    public String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder();
        dfs(t, res);
        return res.toString();
    }

    //Depth-First Search
    public static void dfs(TreeNode t, StringBuilder res) {
        if (t == null)
            return;
        res.append(String.valueOf(t.val));
        if (t.left == null && t.right == null)
            return;
        res.append('(');
        dfs(t.left, res);
        res.append(')');
        if (t.right != null) {
            res.append('(');
            dfs(t.right, res);
            res.append(')');
        }
    }
}
/**
The time complexity is O(N), where N is the number of nodes in the binary tree. We visit each node exactly once during the DFS traversal.

The space complexity is O(H), where H is the height of the binary tree. In the worst case, the recursion stack can go as deep as the height of the tree.
*/
