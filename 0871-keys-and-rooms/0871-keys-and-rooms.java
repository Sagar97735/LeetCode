class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] vis = new boolean[rooms.size()];
        Queue<Integer> q1 = new LinkedList<>();
        for(int i =0; i<rooms.get(0).size();i++){
            q1.add(rooms.get(0).get(i));
        }
        vis[0] = true;
        while(!q1.isEmpty()){
            int curr = q1.poll();
            vis[curr] = true;
            for(int i =0; i<rooms.get(curr).size(); i++){
                int a = rooms.get(curr).get(i);
                if(vis[a]==false && !q1.contains(curr)){
                    q1.add(a);
                    }
            }
        }
        for(int i =0; i<vis.length; i++){
            if(vis[i]==false){
                return false;
            }
        }
        return true;
    }
}