import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int originalNumber) {
        // Step 1: Sort the digits of original number
        String target = sort(originalNumber);
        
        // Step 2: Compare with all powers of 2
        for (int i = 0; i < 31; i++) { // 2^0 to 2^30
            int required = 1 << i; // 2^i
            if (target.equals(sort(required))) {
                return true;
            }
        }
        
        return false;
    }
    
    // Helper function: returns digits of a number in sorted order as a string
    private String sort(int number) {
        char[] digits = String.valueOf(number).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}
