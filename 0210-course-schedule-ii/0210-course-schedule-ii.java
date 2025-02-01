class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
      for(int i =0;i< numCourses; i++){
        arr.add(new ArrayList<>());
      } 
       
       for(int i =0; i<prerequisites.length; i++){
        int a = prerequisites[i][0];
        int b = prerequisites[i][1];
        arr.get(b).add(a);
       } 
       int [] indegree = new int[numCourses];
       for(int i =0; i<arr.size(); i++){
        for(int j =0; j<arr.get(i).size(); j++){
            int neigh = arr.get(i).get(j);
            indegree[neigh]++;
        }
       }
       Queue<Integer> q1 = new LinkedList<>();
       for(int i =0; i< indegree.length; i++){
        if(indegree[i]==0){
            q1.add(i);
        }
       }
       int [] ans = new int[numCourses];
       int [] a1 = new int[1];
       int m = 0;
       int count = 0;
       while(!q1.isEmpty()){
        int a = q1.poll();
        ans[m] = a;
        m++;
        count++;
        for(int i =0; i<arr.get(a).size(); i++){
            int neigh = arr.get(a).get(i);
            indegree[neigh]--;
            if(indegree[neigh]==0){
                q1.add(neigh);
            }
        }
       }
       if(count == numCourses){
        return ans;
       }
       return new int[0];
    }
}