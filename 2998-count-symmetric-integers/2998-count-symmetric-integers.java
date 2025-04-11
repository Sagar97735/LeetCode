class Solution {
    public boolean check(String s ){
        int sum1 = 0;
        int sum2 = 0;
    for(int i =0; i<s.length()/2; i++){
        int a = Integer.parseInt(String.valueOf(s.charAt(i)));
        sum1+=a;
    }
    for(int i =s.length()/2; i<s.length(); i++){
        int a = Integer.parseInt(String.valueOf(s.charAt(i)));
        sum2+=a;
    }        
  if(sum1==sum2){
    return true;
  }
  return false;
    }
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for(int i = low; i<=high; i++){
            String num = String.valueOf(i);
            if(num.length()%2==0){
               if(check(num)){
                cnt++;
               }
            }
        
        }
        return cnt;
    }
}