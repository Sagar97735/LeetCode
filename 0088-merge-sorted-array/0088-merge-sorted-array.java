class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        int j =0;
        while(j<n){
             nums1[i] = nums2[j];
             i++;
             j++;
        }
        int size = m+n;
        int k = 0;
        while(k<size-1){   
              int  a = 0;        
            while(a<size-k-1){
            if(nums1[a]>nums1[a+1]){
                int temp = nums1[a];
                nums1[a] = nums1[a+1];
                nums1[a+1] = temp;
            }
            a++;
        }
        k++;
        }
return ;
        }
}