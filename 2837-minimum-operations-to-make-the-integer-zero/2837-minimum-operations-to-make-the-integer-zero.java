class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long val = (long) num1 - (long) k * num2; // Step 1: equation lagayi
            if (val < k) continue; // Step 2: minimum sum check
            int setBits = Long.bitCount(val); // Step 3: binary me 1s count
            if (setBits <= k && k <= val) return k; // Step 4: condition match
        }
        return -1; // Step 5: koi bhi k work nahi kare
    }
}
