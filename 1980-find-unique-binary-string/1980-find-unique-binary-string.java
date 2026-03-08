class Solution {
    String ans;
    public void solve(StringBuilder st ,List<String> list,int n){
        if(st.length()==n){
            String s = st.toString();
            if(!list.contains(s)){
                ans = s;
                return;
            }
            return;
        }
        st.append("0");
        solve(st,list,n);
        st.deleteCharAt(st.length()-1);

        st.append("1");
        solve(st,list,n);
        st.deleteCharAt(st.length()-1);
        return;
    }
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder st = new StringBuilder();
        int n = nums.length;
        List<String> list = new ArrayList<>();
        for(int i =0; i<nums.length; i++){
            list.add(nums[i]);
        }
        solve(st,list,n);
        return ans;
    }
}