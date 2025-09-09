import java.util.*;

public class Main {
    public static boolean hasCycle(int V, List<int[]> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (adj.get(u).contains(v)) return true;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, -1, visited, adj)) return true;
        }
        return false;
    }

    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) return true;
            } else if (neighbor != parent) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasCycle(5, Arrays.asList(
                new int[]{0,1}, new int[]{1,2}, new int[]{2,3}, new int[]{3,4}, new int[]{4,0})));
        System.out.println(hasCycle(3, Arrays.asList(
                new int[]{0,1}, new int[]{1,2})));
        System.out.println(hasCycle(4, Arrays.asList(
                new int[]{0,1}, new int[]{1,2}, new int[]{2,0})));
        System.out.println(hasCycle(5, new ArrayList<>()));
        System.out.println(hasCycle(3, Arrays.asList(
                new int[]{0,1}, new int[]{0,1})));
    }
}
