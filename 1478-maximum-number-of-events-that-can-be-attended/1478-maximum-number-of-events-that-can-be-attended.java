class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        PriorityQueue <Integer> q1 = new PriorityQueue<>();
        int n = events.length;
        int i =0;
        int day = 1;
        int cnt = 0;
        while(i<n || !(q1.isEmpty())){

            while(i<n && events[i][0]==day){
                q1.offer(events[i][1]);
                i++;
            }
            while(!(q1.isEmpty()) && q1.peek()<day){
                q1.poll();
            }
            if(!(q1.isEmpty())){
                q1.poll();
                cnt++;
            }
            day++;
        }
        return cnt;
    }
}