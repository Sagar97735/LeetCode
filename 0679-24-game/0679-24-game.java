class Solution {
    public boolean judgePoint24(int[] cards) {
        // sab numbers ko double me convert karte hain (division ke liye)
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double)c);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        // base case: agar sirf ek number bacha hai
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6; // tolerance check
        }

        // har do numbers uthao
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue; // same number ko pair na lo

                // new list bana lo jisme baaki numbers honge
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                // ab in do numbers ke results try karo
                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val); // result add karo
                    if (solve(next)) return true; // recursive call
                    next.remove(next.size() - 1); // backtrack
                }
            }
        }
        return false; // agar kuch bhi 24 nahi banaya
    }

    // do numbers ke possible operations
    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > 1e-6) res.add(a / b); // divide by zero avoid
        if (Math.abs(a) > 1e-6) res.add(b / a);
        return res;
    }
}
//<--------------------------------------------------------------------------------C++-------------------------------------------------------------------------------------->
// class Solution {
// public:
//     bool judgePoint24(vector<int>& cards) {
//         // sab numbers ko double me convert karte hain (division ke liye)
//         vector<double> nums;
//         for (int c : cards) nums.push_back((double)c);
//         return solve(nums);
//     }

// private:
//     bool solve(vector<double>& nums) {
//         // base case: agar sirf ek number bacha hai
//         if (nums.size() == 1) {
//             return fabs(nums[0] - 24) < 1e-6; // tolerance check
//         }

//         // har do numbers uthao
//         for (int i = 0; i < nums.size(); i++) {
//             for (int j = 0; j < nums.size(); j++) {
//                 if (i == j) continue; // same number ko pair na lo

//                 // new list bana lo jisme baaki numbers honge
//                 vector<double> next;
//                 for (int k = 0; k < nums.size(); k++) {
//                     if (k != i && k != j) next.push_back(nums[k]);
//                 }

//                 // ab in do numbers ke results try karo
//                 for (double val : compute(nums[i], nums[j])) {
//                     next.push_back(val); // result add karo
//                     if (solve(next)) return true; // recursive call
//                     next.pop_back(); // backtrack
//                 }
//             }
//         }
//         return false; // agar kuch bhi 24 nahi banaya
//     }

//     // do numbers ke possible operations
//     vector<double> compute(double a, double b) {
//         vector<double> res;
//         res.push_back(a + b);
//         res.push_back(a - b);
//         res.push_back(b - a);
//         res.push_back(a * b);
//         if (fabs(b) > 1e-6) res.push_back(a / b); // divide by zero avoid
//         if (fabs(a) > 1e-6) res.push_back(b / a);
//         return res;
//     }
// };

