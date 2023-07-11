/**
 *Problem: 863. All Nodes Distance K in Binary Tree
 *Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 *You can return the answer in any order.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    //The idea is to create a copy of the tree transforming it into a graph where the edges are undirected.
    Map<Integer, List<Integer>> graph;
    List<Integer> answer;
    Set<Integer> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        buildGraph(root, null);
        
        answer = new ArrayList<>();
        visited = new HashSet<>();
        visited.add(target.val);

        dfs(target.val,0,k);

        return answer;      
    }

    //Recursively build the undirected graph from the given binary tree.
    private void buildGraph(TreeNode cur, TreeNode parent){
        if(cur != null && parent != null){
            graph.computeIfAbsent(cur.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(cur.val);
        }
        if(cur.left!=null){
            buildGraph(cur.left,cur);
        }
        if(cur.right!=null){
            buildGraph(cur.right,cur);
        }
    }

    private void dfs(int cur, int distance, int k){
        if(distance == k){
            answer.add(cur);
            return;
        }
        for(int neighbour : graph.getOrDefault(cur, new ArrayList<>())){
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                dfs(neighbour, distance+1,k);
            }
        }
    }
}
