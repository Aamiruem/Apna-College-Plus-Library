
// import java.util.*;

// class Node {

//     public int val;
//     public List<Node> neighbors;

//     public Node() {
//         val = 0;
//         neighbors = new ArrayList<>();
//     }

//     public Node(int _val) {
//         val = _val;
//         neighbors = new ArrayList<>();
//     }

//     public Node(int _val, ArrayList<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }

// public class CloneGraph {

//     public Node cloneGraph(Node node) {
//         if (node == null) {
//             return null;
//         }

//         Map<Integer, Node> map = new HashMap<>();
//         Queue<Node> q = new LinkedList<>();
//         Node head = new Node(node.val);
//         map.put(node.val, head);
//         q.add(node);

//         while (!q.isEmpty()) {
//             Node curr = q.poll();
//             Node clonedNode = map.get(curr.val);

//             for (Node neighbor : curr.neighbors) {
//                 if (!map.containsKey(neighbor.val)) {
//                     Node newNeighbor = new Node(neighbor.val);
//                     map.put(neighbor.val, newNeighbor);
//                     q.add(neighbor);
//                 }
//                 clonedNode.neighbors.add(map.get(neighbor.val));
//             }
//         }
//         return head;
//     }

//     public static void main(String[] args) {
//         // Example usage:
//         Node node1 = new Node(1);
//         Node node2 = new Node(2);
//         Node node3 = new Node(3);
//         Node node4 = new Node(4);

//         node1.neighbors.add(node2);
//         node1.neighbors.add(node4);
//         node2.neighbors.add(node1);
//         node2.neighbors.add(node3);
//         node3.neighbors.add(node2);
//         node3.neighbors.add(node4);
//         node4.neighbors.add(node1);
//         node4.neighbors.add(node3);

//         CloneGraph s = new CloneGraph();
//         s.cloneGraph(node1);

//         System.out.println("Graph cloned successfully!");
//     }
// }

















import java.util.*;

class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    private Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node head = new Node(node.val);
        map.put(node.val, head);
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node clonedNode = map.get(curr.val);

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    Node newNeighbor = new Node(neighbor.val);
                    map.put(neighbor.val, newNeighbor);
                    q.add(neighbor);
                }
                clonedNode.neighbors.add(map.get(neighbor.val));
            }
        }
        return head;
    }

    public static void main(String[] args) {
        CloneGraph s = new CloneGraph();

        // Creating the graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Cloning the graph
        Node cloned = s.cloneGraph(node1);

        // Printing the cloned graph's details
        System.out.println("Cloned Node Value: " + cloned.val);
        System.out.println("Cloned Node Neighbors:");
        for (Node neighbor : cloned.neighbors) {
            System.out.println(neighbor.val);
        }
    }
}
