/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {

        //133. Clone Graph

        HashSet<Integer> visitedNode=new HashSet<>();
        printNode(node,visitedNode,0);

        if(node==null){
            return null;
        }

        HashMap<Integer,Node> visited = new HashMap<>();
        Node copy=new Node(node.val);
        cloneGraph(node,copy,visited);
        return copy;
        
    }

    public void printNode(Node node, HashSet<Integer> visitedNode, int prev){
        if(node==null){
            System.out.println("NUllll");
        }
        if(node!=null && !visitedNode.contains(node.val)){
            visitedNode.add(node.val);
            System.out.println(prev+" : "+node.val);
            prev=node.val;
            for(Node subNode : node.neighbors){
                System.out.println("Edge between " + node.val + " and " + subNode.val);
                printNode(subNode,visitedNode,prev);
                
            }
        }
    }

    public void cloneGraph(Node node, Node copy, HashMap<Integer,Node> visited){
        
        if(! visited.containsKey(copy.val)){
            visited.put(copy.val, copy);
            for(Node subNode : node.neighbors){
                Node copySubNode=visited.getOrDefault(subNode.val, new Node(subNode.val));
                copy.neighbors.add(copySubNode);
                cloneGraph(subNode,copySubNode,visited);
            }
        }
        
    }
}
// By another method
// class Solution {
//     public Node cloneGraph(Node node) {
//         if (node == null) return null;

//         Map<Node, Node> cloneMap = new HashMap<>();
//         return cloneNode(node, cloneMap);
//     }

//     private Node cloneNode(Node node, Map<Node, Node> cloneMap) {
//         if (cloneMap.containsKey(node)) {
//             return cloneMap.get(node);
//         }

//         Node clonedNode = new Node(node.val);
//         cloneMap.put(node, clonedNode);

//         for (Node neighbor : node.neighbors) {
//             clonedNode.neighbors.add(cloneNode(neighbor, cloneMap));
//         }

//         return clonedNode;
//     }
// }