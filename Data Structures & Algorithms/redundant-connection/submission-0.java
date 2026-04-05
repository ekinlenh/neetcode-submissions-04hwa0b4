class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // check for cycle
        // if a node is already visited, then the edge from the node
        // we can from to the node already visited is redundant

        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            boolean[] visited = new boolean[n];

            if (dfs(graph, visited, node1, node2)) {
                return edge;
            }

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return new int[0];
    }

    private boolean dfs(List<List<Integer>> list, boolean[] visited, int node, int parent) {
        if (node == parent) {
            return true;
        }

        visited[node] = true;

        for (int neighbor: list.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(list, visited, neighbor, parent)) {
                    return true;
                }
            }
        }

        return false;
    }
}
