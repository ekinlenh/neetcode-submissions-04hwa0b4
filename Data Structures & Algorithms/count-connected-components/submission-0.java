class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(graph, visited, node);
                components++;
            }
        }

        return components;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {

        // mark each node in the component as visited
        visited[node] = true;

        for (int neighbor: graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}
