// Given a reference of a node in a connected undirected graph.
// Return a deep copy (clone) of the graph.
// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

// Constraints:
//     The number of nodes in the graph is in the range [0, 100].
//     1 <= Node.val <= 100
//     Node.val is unique for each node.
//     There are no repeated edges and no self-loops in the graph.
//     The Graph is connected and all nodes can be visited starting from the given node.


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
        if(node == null) return null;
        if(node.neighbors.isEmpty()) {
            return new Node(node.val);
        }
        Stack<Node> stack = new Stack<Node>();
        HashMap<Node, Node> visited = new HashMap<Node, Node>();
        Node cNode;
        Node p = null;
        stack.push(node);
        cNode = new Node(node.val);
        visited.put(node, cNode);
        while(!stack.empty()) {
            p = stack.peek();
            for(Node n: p.neighbors) {
                if(visited.containsKey(n) == false){
                    cNode = new Node(n.val);
                    visited.get(p).neighbors.add(cNode);
                    visited.put(n, cNode);
                    stack.push(n);
                    break;    
                }
                else{
                    cNode = visited.get(n);
                    if(visited.get(p).neighbors.contains(cNode) == false) {
                        visited.get(p).neighbors.add(cNode);   
                    }
                    cNode = null;  
                } 
             } 
            if(cNode == null) p = stack.pop();
        }
        return visited.get(p);
    }
}
