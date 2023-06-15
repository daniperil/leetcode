/**
 *Problem: 1161. Maximum Level Sum of a Binary Tree
 *Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
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
    public int maxLevelSum(TreeNode root) {

        int maxSum = Integer.MIN_VALUE;
        int respLevel = 0;
        int level = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            level++;
            int sumAtCurrentLevel = 0;
            //Iterate over all the nodes in the current level.

            //Use of prefix operator in --s (there is also a postfix operator s--)
            //q.siz() gives the number of elements in the queue
            for(int s = q.size(); s>0; --s){
                //q.poll() is used to retrieve and remove the element at the head of the queue
                TreeNode node = q.poll();
                sumAtCurrentLevel += node.val;

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }

            }

            if(maxSum<sumAtCurrentLevel){
                maxSum = sumAtCurrentLevel;
                respLevel = level;
            }
        }
        return respLevel;
    }
}
