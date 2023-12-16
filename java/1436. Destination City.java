/**
 *Problem: 1436. Destination City
 *You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
 *It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 */

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> hasOutgoing = new HashSet();
        for(int i = 0; i < paths.size(); i++){
            hasOutgoing.add(paths.get(i).get(0));
        }

        for(int i = 0; i < paths.size(); i++){
            String candidate = paths.get(i).get(1);
            if(!hasOutgoing.contains(candidate)){
                return candidate;
            }
        }
        
        return "";
        
        
    }
}

/**
 *Time complexity: O(n)O(n)O(n)
 *We first iterate over paths to populate hasOutgoing, this costs O(n)O(n)O(n).
 *Next, we iterate over paths again to find the answer, checking at each step whether candidate is in the hash set, which takes O(1)O(1)O(1). Thus the iteration costs O(n)O(n)O(n).
 *Space complexity: O(n)O(n)O(n)
 *hasOutgoing will grow to a size of O(n)O(n)O(n).
 */
