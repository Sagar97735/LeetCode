class Solution {
 public String pushDominoes(String dominoes) {
    char[] res = new char[dominoes.length()];
    Queue<Integer> queue = new LinkedList<>();
    
    for(int i = 0 ; i < dominoes.length() ; i++){
        if(dominoes.charAt(i) != '.') 
            queue.add(i);
        res[i] = dominoes.charAt(i);
    }
    
    while(!queue.isEmpty()){
        int size = queue.size();
        
        Map<Integer , Character> map = new HashMap<>();
        
        while(size-- > 0){
            int index = queue.poll();
            if(res[index] != '.'){
                if(res[index] == 'L'){
                    if(index - 1 >= 0 && res[index - 1] == '.'){
                        if(map.containsKey(index - 1)) 
                            map.remove(index - 1);
                        else{
                            map.put(index - 1 , 'L');
                            queue.add(index - 1);
                        }
                    }
                }else{
                    if(index + 1 < res.length && res[index + 1] == '.'){
                        if(map.containsKey(index + 1)) 
                            map.remove(index + 1);
                        else{
                            map.put(index + 1 , 'R');
                            queue.add(index + 1);
                        } 
                    }
                }
            }
        }
        
        for(int key : map.keySet())
            res[key] = map.get(key); 
        
    }
    
    return String.valueOf(res);
}
}