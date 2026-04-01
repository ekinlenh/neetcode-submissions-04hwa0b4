class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // store course numbers with in-degrees of 0
        Queue<Integer> queue = new LinkedList<>();

        // store indegrees here where index = course number
        int[] indegrees = new int[numCourses];

        // adjaceny list for the array
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // initialize list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // fill in indegrees for courses
        for (int[] pre: prerequisites) {
            int courseNumber = pre[0];
            int preReq = pre[1];

            graph.get(preReq).add(courseNumber);
            indegrees[courseNumber]++;
        }

        // add in-degrees of 0 to queue
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        // traverse graph to see if we can finish all courses
        int coursesTaken = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int courseNumber = queue.poll();
            res[coursesTaken] = courseNumber;
            coursesTaken++;

            for (int neighbor: graph.get(courseNumber)) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        if (coursesTaken == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}
