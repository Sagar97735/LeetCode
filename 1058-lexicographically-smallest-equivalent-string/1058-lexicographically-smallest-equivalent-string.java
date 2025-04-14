class Solution {
    String ans = "";
    public void isSolve(char parent,char child,List<List<Character>> arr,int [] min,char [] arr1, boolean[] visited){
         int ch = child-'a';
        if (visited[ch]) return;
        visited[ch] = true;
         if(ch<min[0]){
            min[0] = ch;
            arr1[0] = child;
         }
         for(int i =0; i<arr.get(ch).size(); i++){
            char c = arr.get(ch).get(i);
            if(c!=parent){
                isSolve(child,c ,arr,min,arr1,visited);
            }
         }

    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<List<Character>> arr = new ArrayList<>();
        for(int i = 0; i<26; i++){
            arr.add(new ArrayList<>());
        }
        for(int i =0; i<s1.length(); i++){
            int u = s1.charAt(i)-'a';
            int v = s2.charAt(i)-'a';
            arr.get(u).add(s2.charAt(i));
            arr.get(v).add(s1.charAt(i));
        }
        for(int i =0; i<baseStr.length();i++){
            char [] arr1 = new char[1];
            int[] min = new int[]{27}; 
            boolean[] visited = new boolean[26];
            char c = baseStr.charAt(i);
            isSolve('\0',c,arr,min,arr1,visited);   
            ans+=arr1[0];  
        }
            return ans;
    }
}