class Solution {
    public int countCollisions(String directions) {
        int collision = 0;
        Stack<Character> s1 = new Stack<>();
        int i = 0;
        boolean coll = false;
        while(i<directions.length()){
            char c = directions.charAt(i);
            if(c=='R'||c=='S'){
                coll = true;
            }
            if(!s1.isEmpty() && s1.peek()=='R'){
            if( c=='L') {
                   collision+=2;
                   s1.pop();
                }
             if(c=='S'|| c =='L'){
                    while(!s1.isEmpty() && s1.peek()=='R'){
                        collision++;
                        s1.pop();
                    }
                }
            }
            else if(c=='L' && coll == true){
                collision++;
            }
             
            if( c=='R' || c=='S'){
                s1.push(c);
            }
                i++;
        }
        return collision;
    }
}