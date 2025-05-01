class Solution {
    public char find(char c,char parent[]){
       if(c==parent[c-'a']){
        return c;
       }
      return parent[c-'a']= find(parent[c-'a'],parent);
    }
    public void union(char a,char b,char [] parent){
        char a_parent = find(a,parent);
        char b_parent = find(b,parent);
        if(a_parent!=b_parent){
              parent[a_parent-'a'] = b_parent;
        }
    }
    public boolean equationsPossible(String[] equations) {
        char [] parent = new char[26];
        for(char i = 'a'; i<='z'; i++){
            parent[i-'a']= i;
        } 
        for(int i =0; i<equations.length; i++){
            String str = equations[i];
            if(str.charAt(1)=='='&& str.charAt(2)=='='){
                union(str.charAt(0),str.charAt(3),parent);
            }
        }
        for(int i =0; i<equations.length; i++){
            String str = equations[i];
             if(str.charAt(1)=='!'&& str.charAt(2)=='='){
            char parent1 = find(str.charAt(0),parent);
            char parent2 = find(str.charAt(3),parent);
                if(parent1==parent2){
                    return false;
                }
             }
        }
        
        return true;
    }
}