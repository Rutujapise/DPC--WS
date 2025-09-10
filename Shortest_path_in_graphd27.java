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
            graph.get(v).add(u); // undirected graph
        }

        // If start and end are the same
        if (start == end) return 0;

        // BFS queue: stores (node, distance)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        boolean[] visited = new boolean[V];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            if (node == end) {
                return dist;
            }

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }

        // If no path found
        return -1;
    }

    public static void main(String[] args) {
        int V1 = 5;
        int[][] edges1 = {{0,1},{0,2},{1,3},{2,3},{3,4}};
        System.out.println(shortestPath(V1, edges1, 0, 4)); // 3

        int V2 = 3;
        int[][] edges2 = {{0,1},{1,2}};
        System.out.println(shortestPath(V2, edges2, 0, 2)); // 2

        int V3 = 4;
        int[][] edges3 = {{0,1},{1,2}};
        System.out.println(shortestPath(V3, edges3, 2, 3)); // -1

        int V4 = 3;
        int[][] edges4 = {};
        System.out.println(shortestPath(V4, edges4, 1, 1)); // 0
    }
}
