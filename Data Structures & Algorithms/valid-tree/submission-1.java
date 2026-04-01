class Solution {
    public boolean validTree(int n, int[][] edges) {
        // a valid tree:
        // n - 1 edges, is connected, and has no cycles
        // how can we check for this?

        // check for cycles: run DFS
        // if reach a visited node already, then there's a cycle

        if (edges.length != (n - 1)) {
            return false;
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // adjacency list
        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        // start from first node: Node 0 and run DFS
        boolean[] visited = new boolean[n];
        if (!dfs(list, visited, 0, 0)) {
            return false;
        }
        
        for (boolean v: visited) {
            if (!v) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> list, boolean[] visited, int node, int parent) {
        visited[node] = true;

        for (int neighbor: list.get(node)) {

            if (neighbor == parent) continue;

            if (visited[neighbor]) return false;

            if (!dfs(list, visited, neighbor, node)) return false;
        }

        return true;
    }
}
