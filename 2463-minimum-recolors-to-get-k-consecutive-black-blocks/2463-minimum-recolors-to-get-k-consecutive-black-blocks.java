class Solution {
    public int minimumRecolors(String blocks, int k) {  
        int white = 0;
        
        // Count white blocks in the first window of size k
        for(int i = 0; i < k; i++){
            if (blocks.charAt(i) == 'W') {
                white++;
            }
        }
        
        int min = white;
        
        // Sliding window technique
        for(int i = k; i < blocks.length(); i++){
            if (blocks.charAt(i - k) == 'W') {
                white--; // Remove the outgoing element from window
            }
            if (blocks.charAt(i) == 'W') {
                white++; // Add the incoming element to window
            }
            min = Math.min(min, white);
        }
        
        return min;
    }
}
