/**
 *Problem: 1514. Path with Maximum Probability
 *You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
 *Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.
 *If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.
 */

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        //Use breadth-first search algorithm (BFS) to explore the graph.

        //The graph is represented using an adjacency list, where each node is associated with a list of its neighboring nodes and their corresponding success probabilities.
        
        //Use queue data structure to perform a BFS traversal of the graph, starting from athe given starting node.

        //Adjacency list

        List<List<Pair<Integer,Double>>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair<>(v,p));
            adj.get(v).add(new Pair<>(u,p));
        }

        //Distances array
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start] = 1.0;

        //Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(Pair<Integer, Double> pair : adj.get(curr)){
                int node = pair.getKey();
                double prob = pair.getValue();
                double newProb = dist[curr]*prob;

                if(newProb>dist[node]){
                    dist[node] = newProb;
                    queue.offer(node);
                }
            }
        }

        return dist[end];

    }

    private class Pair<K,V>{
        private K key;
        private V value;

        public Pair(K key,V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}
