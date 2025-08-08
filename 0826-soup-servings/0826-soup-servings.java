// class Solution {
//     public double soupServings(int n) {
//         return serve(n, n);
//     }

//     private double serve(int a, int b) {
//         // Base cases
//         if (a <= 0 && b <= 0) return 0.5;
//         if (a <= 0) return 1.0;
//         if (b <= 0) return 0.0;

//         // Recursive case
//         return 0.25 * (
//             serve(a - 100, b) +
//             serve(a - 75, b - 25) +
//             serve(a - 50, b - 50) +
//             serve(a - 25, b - 75)
//         );
//     }
// }
//memoizeation
class Solution {
    public double soupServings(int n) {
        // Optimization: For very large n, probability ~ 1
        if (n >= 4800) return 1.0;

        int N = (n + 24) / 25; // scale down to units of 25 mL
        Double[][] memo = new Double[N + 1][N + 1];
        return serve(N, N, memo);
    }

    private double serve(int a, int b, Double[][] memo) {
        // Base cases
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        // Return stored result if available
        if (memo[a][b] != null) return memo[a][b];

        // Recursive case with memoization
        double res = 0.25 * (
            serve(a - 4, b, memo) +
            serve(a - 3, b - 1, memo) +
            serve(a - 2, b - 2, memo) +
            serve(a - 1, b - 3, memo)
        );

        memo[a][b] = res;
        return res;
    }
}
