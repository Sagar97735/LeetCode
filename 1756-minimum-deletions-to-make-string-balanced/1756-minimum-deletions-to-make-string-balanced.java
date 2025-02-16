class Solution {
    public int minimumDeletions(String s) {
        int deleteCount = 0;  // Deletions needed to remove "ba" patterns
        int bCount = 0;       // Count of 'b's encountered
        
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                bCount++;  // Count number of 'b's seen so far
            } else { // ch == 'a'
                if (bCount > 0) {
                    deleteCount++; // We can either delete this 'a' or a previous 'b'
                    bCount--; // Instead of deleting 'a', we assume removing one 'b'
                }
            }
        }
        return deleteCount;
    }
}
