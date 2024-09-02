class Solution {
    public int firstUniqChar(String s) {
        // HashMap<Character,Integer> h1 = new HashMap<>();
        // for(int i = 0; i<s.length(); i++){
        //     if(h1.containsKey(s.charAt(i))){
        //         int a = h1.get(s.charAt(i)) + 1;
        //         h1.put(s.charAt(i),a);
        //     }
        //     else{
        //         h1.put(s.charAt(i),1);
        //     }
        // }
        // char ans = '0';
        // int i = 0;
        // while(i<s.length()){
        //      if(h1.get(s.charAt(i))==1){
        //         return i;
        //      }
        //      else{
        //         i++;
        //      }
        // }
        // return -1;
          // Stores lowest index / first index
        int ans = Integer.MAX_VALUE;
        // Iterate from a to z which is 26 which makes it constant
        for(char c='a'; c<='z';c++){
            // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }

        // If ans remain's Integer.MAX_VALUE then their is no unique character
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}