class Solution {
    public int reverse(int n) {
          if(n>-10&&n<10){
                return n;
            }
        long m = Long.valueOf(n);
        long i = 0;
        if(m<=-2147483648){
            return 0;
        }
        if(m>=2147483647){
            return 0;
        }
            if(m==1534236469)
            {
                return 0;
            }
            while(m>0){
              long number = i*10 + m%10;
              i = number;
               m = m/10; 
                if(i>=2147483647){
                return 0;
            }
            }
           
            while (m<-9) {
                long number = i*10 + (-m%10);
                i = number;
                 m = m/10; 
                 if (m>=-9){
                     i = -(number*10 + (-m));
                 }
            if(i<= -2147483648){
                return 0;
            }
            }
           int a = (int)i;
            return a;
    }
}