class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
       for(int j=0; j<numCourses; j++){
        arr.add(new ArrayList<>());
       }
        for(int i=0; i<prerequisites.length; i++){
          arr.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int [] indegree = new int[numCourses];
        Queue<Integer> q1 = new LinkedList<>();
        for(int i =0; i<prerequisites.length; i++){
           int a = prerequisites[i][0];
           int b = prerequisites[i][1];
           indegree[a]++;
        }
       for(int i = 0; i<indegree.length; i++){
        if(indegree[i]==0){
            q1.add(i);
        }
       }
       int cnt = 0;
       ArrayList<Integer> arr1 = new ArrayList<>();
       while(!q1.isEmpty()){
         int curr = q1.poll();
         arr1.add(curr);
         cnt++;
         for(int i = 0; i<arr.get(curr).size(); i++){
            int a = arr.get(curr).get(i);
            indegree[a]--;
            if(indegree[a]==0){
                q1.add(a);
            }
         }
       }
       int [] ans = new int[numCourses];
       for(int i= 0; i< arr1.size(); i++){
           ans[i] = arr1.get(i);
       }
       if(cnt!=numCourses){
        return new int[0];
       }
       return ans;
    }
}