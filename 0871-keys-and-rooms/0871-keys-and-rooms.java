class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue <Integer> q1 = new LinkedList<>();
        q1.add(0);
        boolean [] vis = new boolean[rooms.size()];
        vis[0] = true;
        while(!q1.isEmpty()){
            int curr = q1.poll();
            for(int i = 0; i<rooms.get(curr).size(); i++){
                int a = rooms.get(curr).get(i);
                if(!vis[a]){
                    q1.add(a);
                    vis[a] = true;
                }
            }
        }
        for(int i =0; i<vis.length; i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
}