class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Using a set to store the obstacles in "x,y" format for O(1) lookups
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Direction vectors for moving up, right, down, left
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;  // Start facing up
        int x = 0, y = 0;
        int maxDistance = 0;

        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;  // Turn right
            } else if (command == -2) {
                dir = (dir + 3) % 4;  // Turn left
            } else {
                for (int k = 0; k < command; k++) {
                    int nextX = x + directions[dir][0];
                    int nextY = y + directions[dir][1];
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;  // Stop if there's an obstacle
                    }
                    x = nextX;
                    y = nextY;
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }

        return maxDistance;
    }
}


    
