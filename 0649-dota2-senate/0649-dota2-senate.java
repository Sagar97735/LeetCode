import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Fill queues with the index of the senators
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Process the voting round by round
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // The one with the smaller index bans the other one
            if (rIndex < dIndex) {
                // Radiant senator bans Dire senator and will vote again in the next round
                radiant.offer(rIndex + senate.length());
            } else {
                // Dire senator bans Radiant senator and will vote again in the next round
                dire.offer(dIndex + senate.length());
            }
        }

        // If radiant queue is empty, Dire wins, otherwise Radiant wins
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
