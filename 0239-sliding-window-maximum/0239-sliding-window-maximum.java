class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return nums;
        int p=0;
        int ans[] = new int[n-k+1];
        Deque <Integer> dq = new LinkedList<>();
        for(int i=0; i<n; i++){
            //Checking for the out of window element
            if(!dq.isEmpty() && dq.peekFirst() == i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i+1 >= k){
                ans[p] = nums[dq.peek()];
                p++;
            }
        }
        return ans;
    }
}