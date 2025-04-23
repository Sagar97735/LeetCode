class Solution {
    public int sum(int n){
        if(n<10){
            return n;
        }
        int ans=0;
       while(n>0){
            ans+=(n%10);
            n=n/10;
       }
       return ans;
    }
    public int countLargestGroup(int n) {
        int [] arr = new int[10000];
        int size = 1;
        int ans = 0;
        for(int i=1; i<=n; i++){
            int a = sum(i);
          arr[a]++;
          size = Math.max(size,arr[a]);
        }
          System.out.println(arr[5]);
        for(int i =0; i<arr.length; i++){
            if(arr[i]==size){
                ans++;
            }
        }
        return ans;
    }
}