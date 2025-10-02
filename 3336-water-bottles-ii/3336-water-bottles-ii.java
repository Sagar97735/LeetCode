class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = numBottles;
        int drunk = numBottles;
        int full = 0;
        int exc = numExchange;
        while(empty >=exc ){
              empty-=exc;
              full +=1;
              exc+=1;
              if(empty<=exc){
                empty+=full;
                drunk+=full;
                full = 0;
              }
        }
        return drunk;
    }
}