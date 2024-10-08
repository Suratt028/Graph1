public class Graph {
    private String[] nodes;  // 1D array to store node information
    private int[][] adjacencyMatrix;  // 2D array to store adjacency links

    // Constructor to initialize the graph with a given number of nodes
    public Graph(int numberOfNodes) {
        nodes = new String[numberOfNodes];
        adjacencyMatrix = new int[numberOfNodes][numberOfNodes];
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
            adjacencyMatrix[from][to] = weight;
            adjacencyMatrix[to][from] = weight;  // For undirected graph
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

        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);  // กราฟมี 8 nodes

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

//Adjacency Matrix:
//0 2 0 0 3 0 0 1 
//2 0 7 0 0 0 0 1 
//0 7 0 1 0 0 0 0 
//0 0 1 0 2 0 0 1 
//3 0 0 2 0 4 5 0 
//0 0 0 0 4 0 0 0 
//0 0 0 0 5 0 0 0 
//1 1 0 1 0 0 0 0
