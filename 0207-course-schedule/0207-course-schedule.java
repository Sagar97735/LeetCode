class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i =0; i< numCourses; i++){
            arr.add(new ArrayList<>());
        }
        for(int i =0; i< prerequisites.length; i++){
         int a = prerequisites[i][0];
         int b = prerequisites[i][1];
         arr.get(b).add(a);              
        }
       int [] indegree = new int[numCourses];
       for(int i =0; i< arr.size(); i++){
        for(int j =0; j<arr.get(i).size(); j++){
            indegree[arr.get(i).get(j)]++;
        }
       }
       Queue<Integer> q1 = new LinkedList<>();
       for(int i =0; i<indegree.length; i++){
        if(indegree[i]==0){
            q1.add(i);
        }
       }
       int count = 0;
       while(!q1.isEmpty()){
        int a = q1.poll();
        count++;
        for(int i = 0; i<arr.get(a).size(); i++){
            int neigh = arr.get(a).get(i);
            indegree[neigh]--;
            if(indegree[neigh]==0){
                q1.add(neigh);
            }
        }
       }
       if(numCourses == count){
        return true;
       }
       return false;
    }
}