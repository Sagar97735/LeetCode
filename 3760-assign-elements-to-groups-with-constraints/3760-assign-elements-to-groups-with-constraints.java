// class Solution {
//     public int[] assignElements(int[] groups, int[] elements) {
//         int n = groups.length;
//         int[] ans = new int[n];
//         Arrays.fill(ans, -1);
        
//         TreeSet<Integer> indices = new TreeSet<>();
//         for (int i = 0; i < n; i++) {
//             indices.add(i);
//         }
        
//         for (int j = 0; j < elements.length; j++) {
//             Iterator<Integer> it = indices.iterator();
//             while (it.hasNext()) {
//                 int i = it.next();
//                 if (ans[i] == -1 && groups[i] >= elements[j] && groups[i] % elements[j] == 0) {
//                     ans[i] = j;
//                     it.remove();  // Efficient removal
//                 }
//             }
//         }
        
//         return ans;
//     }
// }
class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
         int ans[]=new int[100001];
         for(int i=0;i<ans.length;i++)
          ans[i]=-1;
         
         for(int i=0;i<elements.length;i++)
         {
             int val=elements[i];
             if(ans[val]!=-1)
              continue;
             for(int j=val;j<ans.length;j+=val)
             {
                 if(ans[j]==-1)
                    ans[j]=i;
             }
         }
         int res[]=new int[groups.length];
         for(int i=0;i<res.length;i++)
          res[i]=ans[groups[i]];
         return res;
    }
}
