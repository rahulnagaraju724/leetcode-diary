class Solution {
    public int findCenter(int[][] edges) {
        //1791. Find Center of Star Graph
        //Shorcut
        // int a=edges[0][0];
        // int b=edges[0][1];
        // if(a==edges[1][0] || a==edges[1][1]){
        //     return a;
        // }
        // if(b==edges[1][0] || b==edges[1][1]){
        //     return b;
        // }
        // return 0;

        //Actual Solution
        Map<Integer, Integer> degrees = new HashMap<>();

        // Count degrees for each node
        for (int[] edge : edges) {
            degrees.put(edge[0], degrees.getOrDefault(edge[0], 0) + 1);
            degrees.put(edge[1], degrees.getOrDefault(edge[1], 0) + 1);
        }

        // Find the node with degree equal to n - 1
        for (Map.Entry<Integer, Integer> entry : degrees.entrySet()) {
            if (entry.getValue() == edges.length) {
                return entry.getKey();
            }
        }
        return -1;
    }
}