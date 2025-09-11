import java.util.*;

public class ShortestPathUnweighted {
    public static int shortestPath(int V, int[][] edges, int start, int end) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, -1);

        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == end) return distance[node]; // Found shortest path

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return -1; // No path found
    }

    public static void main(String[] args) {
        // Test Case 1
        int V1 = 5;
        int[][] edges1 = {{0,1},{0,2},{1,3},{2,3},{3,4}};
        System.out.println(shortestPath(V1, edges1, 0, 4)); // Output: 3

        // Test Case 2
        int V2 = 3;
        int[][] edges2 = {{0,1},{1,2}};
        System.out.println(shortestPath(V2, edges2, 0, 2)); // Output: 2

        // Test Case 3
        int V3 = 4;
        int[][] edges3 = {{0,1},{1,2}};
        System.out.println(shortestPath(V3, edges3, 2, 3)); // Output: -1

        // Edge Case: start == end
        int V4 = 1;
        int[][] edges4 = {};
        System.out.println(shortestPath(V4, edges4, 0, 0)); // Output: 0
    }
}
