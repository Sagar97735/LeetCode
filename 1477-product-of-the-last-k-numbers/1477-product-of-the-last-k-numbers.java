class ProductOfNumbers {
       List<Integer> arr = new ArrayList<>();
    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        arr.add(num);
    }
    
    public int getProduct(int k) {
        int i =arr.size()-1;
        int a =0;
        int ans = 1;
        while(a!=k){
              ans*=arr.get(i);
              i--;
              a++;
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */