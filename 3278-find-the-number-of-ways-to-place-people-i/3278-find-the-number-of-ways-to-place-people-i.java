class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (point1, point2) -> {
            if (point1[0] == point2[0]) {
                return Integer.signum(point2[1] - point1[1]);
            } else {
                return Integer.signum(point1[0] - point2[0]);
            }
        });
        int countOfPairs = 0;
        for (int i = 0; i < n; i++) {
            int upperY = points[i][1];
            int leftX = points[i][0];
            int lowerY = -50;
            for (int j = i + 1; j < n; j++) {
                if (points[j][1] > upperY)
                    continue;
                if (points[j][0] < leftX)
                    continue;
                if (points[j][1] <= lowerY)
                    continue;
                countOfPairs++;
                lowerY = points[j][1];
                leftX = points[j][0] + 1;
            }
        }
        return countOfPairs;
    }
}

//--------------------------------------------C++---------------------------------------------------------------------------------
// #include <vector>
// #include <algorithm>
// using namespace std;

// class Solution {
// public:
//     int numberOfPairs(vector<vector<int>>& points) {
//         int n = points.size();

//         // Step 1: Sort by x ascending, y descending
//         sort(points.begin(), points.end(), [](const vector<int>& a, const vector<int>& b) {
//             if (a[0] != b[0]) return a[0] < b[0];
//             return a[1] > b[1];
//         });

//         int count = 0;

//         // Step 2: Fix each point as upper-left
//         for (int i = 0; i < n; i++) {
//             int upperY = points[i][1];
//             int leftX = points[i][0];
//             int lowerY = -1;

//             // Step 3: Scan right side points
//             for (int j = i + 1; j < n; j++) {
//                 int xj = points[j][0], yj = points[j][1];

//                 if (yj > upperY) continue;
//                 if (xj < leftX) continue;
//                 if (yj <= lowerY) continue;

//                 count++;
//                 lowerY = yj;
//                 leftX = xj + 1;
//             }
//         }

//         return count;
//     }
// };
