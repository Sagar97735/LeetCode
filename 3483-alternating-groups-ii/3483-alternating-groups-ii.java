class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        int [] arr = new int[colors.length + k-1];
        for(int i =0; i< colors.length; i++){
            arr[i] = colors[i];
        }
        int i = 0;
        for(int a=colors.length; a<arr.length; a++){
            arr[a] = colors[i];
            i++;
        }
        int j = 0;
        int l=1;
        int cnt = 0;
      while(l<arr.length){
      if(arr[l]!=arr[l-1] && l-j+1==k){
        l++;
        j++;
        cnt++;
      }
     else if(arr[l]!=arr[l-1] && l-j+1!=k){
        l++;
      }
      else{
        j = l;
        l++;
      }
      }
      return cnt;
    }
}







