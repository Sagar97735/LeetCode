class Solution {
    public boolean solve(int[] arr, int i , boolean [] visited){
        if(i>=arr.length || i<0 || visited[i])return false;
        if(arr[i]==0){
            return true;
        }
        visited[i] = true;
        return solve(arr,i+arr[i],visited) ||  solve(arr,i-arr[i] , visited);
    }
    public boolean canReach(int[] arr, int start) {
        boolean [] visited = new boolean[arr.length];
        return solve(arr,start,visited);
    }
}