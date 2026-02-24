class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int cnt = 0;
        Queue<Integer> q1 = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            arr.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][0];
            indegree[src]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q1.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int j = 0;
        if(q1.isEmpty()){
            return new int[0];
        }
        while (!q1.isEmpty()) {
            int ele = q1.poll();
            cnt++;
            ans[j] = ele;
            j++;
            for (int i = 0; i < arr.get(ele).size(); i++) {
                int src = arr.get(ele).get(i);
                indegree[src]--;
                if (indegree[src] == 0) {
                    q1.add(src);
                }
            }

        }
        if(cnt!=numCourses){
            return new int[0];
        }
        return ans;
    }
}