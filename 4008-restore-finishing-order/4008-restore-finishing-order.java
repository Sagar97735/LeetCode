class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
    int [] ans = new int[friends.length];
    ArrayList<Integer> arr = new ArrayList<>();
    for(int i =0; i<friends.length; i++){
        arr.add(friends[i]);
    }
     int j =0;
     for(int i =0; i<order.length; i++){
        if(arr.contains(order[i])){
            ans[j] = order[i];
            j++;
        }
     }
     return ans;
    }
}