class Solution {
    public int maximum69Number(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        // Change the first '6' to '9'
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // only first '6' needs to be changed
            }
        }
        
        // Convert back to int
        return Integer.parseInt(new String(digits));
    }
}
