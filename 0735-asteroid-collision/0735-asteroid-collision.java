class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s1 = new Stack<>();
        int i = 1;
        s1.push(asteroids[0]);
        while(i < asteroids.length){
             if(!(s1.isEmpty()) && asteroids[i]== -s1.peek() && s1.peek()>0){
            s1.pop();
            i++;
        }
        else if(!(s1.isEmpty()) && s1.peek()>0 && asteroids[i]<0){
            int a = Math.max(Math.abs(asteroids[i]),s1.peek());
            if(asteroids[i]== -a){
                s1.pop();
            }
            else{
                i++;
            }
        }
           else{ 
            s1.push(asteroids[i]);
            i++;
           }
        }
     int [] arr1 = new int[s1.size()];
     for(int j = arr1.length-1; j>=0; j--){
      arr1[j] = s1.pop();
     }
     return arr1;
    }
}