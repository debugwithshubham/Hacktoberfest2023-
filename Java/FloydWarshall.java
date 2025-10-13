import java.util.Arrays;

public class FloydWarshall {
    private static final int INF = 99999; // Use a large number to represent "infinity"

    // Function to implement Floyd-Warshall algorithm
    public static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize the distance matrix with the input graph
        for (int i = 0; i < V; i++) {
            dist[i] = Arrays.copyOf(graph[i], V);
        }

        // Main Floyd-Warshall logic
        for (int k = 0; k < V; k++) { // for each intermediate vertex
            for (int i = 0; i < V; i++) { // for each source vertex
                for (int j = 0; j < V; j++) { // for each destination vertex
                    // If vertex k is on the shortest path from i to j, update dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    // Helper function to print the distance matrix
    private static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

        floydWarshall(graph);
    }
}


/*Description for Contribution

Floyd-Warshall Algorithm is a dynamic programming algorithm used to find shortest paths between all pairs of vertices in a weighted graph. It works for both directed and undirected graphs, and can handle negative edge weights (but not negative cycles).

Key Points:

Time Complexity: 
𝑂(𝑉3)O(V3), where V = number of vertices.

Space Complexity: 
𝑂(𝑉2)O(V2) for the distance matrix.

Approach:

Initialize the distance matrix with the edge weights.

Use each vertex as an intermediate node to check if a shorter path exists via that vertex.

Update the distance matrix accordingly.

Handling Infinity: We represent no direct edge using a large constant (INF).

Output: A matrix showing the shortest distance between every pair of vertices. */