import java.util.LinkedList;

public class GraphMixed {
    private String[] nodes;  // 1D array to store node information
    private LinkedList<Edge>[] adjacencyList;  // Adjacency list to store edges

    // Constructor to initialize the graph with a given number of nodes
    public GraphMixed(int numberOfNodes) {
        nodes = new String[numberOfNodes];
        adjacencyList = new LinkedList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add a node with a label
    public void addNode(int index, String label) {
        if (index >= 0 && index < nodes.length) {
            nodes[index] = label;
        } else {
            System.out.println("Node index out of bounds");
        }
    }

    // Method to add an edge between two nodes
    public void addEdge(int from, int to, int weight) {
        if (from >= 0 && from < nodes.length && to >= 0 && to < nodes.length) {
            adjacencyList[from].add(new Edge(to, weight));
            adjacencyList[to].add(new Edge(from, weight));  // For undirected graph
        } else {
            System.out.println("Node index out of bounds");
        }
    }

    // Method to display the graph
    public void displayGraph() {
        System.out.println("Nodes:");
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(i + ": " + nodes[i]);
        }

        System.out.println("\nAdjacency List:");
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.print(nodes[i] + " -> ");
            for (Edge edge : adjacencyList[i]) {
                System.out.print(nodes[edge.to] + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Class to represent an edge with a destination node and weight
    private static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        GraphMixed graph = new GraphMixed(8);  // กราฟมี 8 nodes

        // Adding nodes
        graph.addNode(0, "A");
        graph.addNode(1, "B");
        graph.addNode(2, "C");
        graph.addNode(3, "D");
        graph.addNode(4, "E");
        graph.addNode(5, "H");
        graph.addNode(6, "J");
        graph.addNode(7, "K");

        // Adding edges (based on the graph in the image)
        graph.addEdge(0, 1, 2); // A - B (2)
        graph.addEdge(0, 4, 3); // A - E (3)
        graph.addEdge(0, 7, 1); // A - K (1)
        graph.addEdge(1, 7, 1); // B - K (1)
        graph.addEdge(1, 2, 7); // B - C (7)
        graph.addEdge(2, 3, 1); // C - D (1)
        graph.addEdge(3, 4, 2); // D - E (2)
        graph.addEdge(3, 7, 1); // D - K (1)
        graph.addEdge(4, 5, 4); // E - H (4)
        graph.addEdge(4, 6, 5); // E - J (5)

        // Display the graph
        graph.displayGraph();
    }
}
// แสดงผล
//Nodes:
//0: A
//1: B
//2: C
//3: D
//4: E
//5: H
//6: J
//7: K

//Adjacency List:
//A -> B(2) E(3) K(1) 
//B -> A(2) K(1) C(7) 
//C -> B(7) D(1) 
//D -> C(1) E(2) K(1) 
//E -> A(3) D(2) H(4) J(5) 
//H -> E(4) 
//J -> E(5) 
//K -> A(1) B(1) D(1)
