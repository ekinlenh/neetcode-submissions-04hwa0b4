class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // we can do topological sort using BFS
        // find how many in-degrees of each vertex
        // then, add vertices of in-degree 0 to queue
        // remove from queue and reduce in-degrees of neighbors
        // repeat: add vertices of in-degree 0 to queue
        // each time we remove from queue, increment current courses taken
        // then we can return if courses taken = numCourses

        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // create adjaceny list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // build graph
        for (int[] pre: prerequisites) {
            int courseNumber = pre[0];
            int preReq = pre[1];

            graph.get(preReq).add(courseNumber);
            indegree[courseNumber]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int courseNumber = queue.poll();
            coursesTaken++;

            for (int neighbor: graph.get(courseNumber)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return coursesTaken == numCourses;
    }
}
