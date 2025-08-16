class Solution {
    public int maximum69Number (int num) {
     int max = num;
     String s1 = "";
     s1+=num;
     for(int i = 0; i<s1.length(); i++){
     StringBuilder s = new StringBuilder();   
     s.append(num);
        char ch = s.charAt(i);
        if(ch=='6'){
           s.setCharAt(i, '9');
        }
        String str = s.toString();
        int number = Integer.parseInt(str);
        max = Math.max(max,number);
     }   
     return max;
    }
}