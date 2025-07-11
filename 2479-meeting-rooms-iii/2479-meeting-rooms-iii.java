import java.util.*;

class Solution {
    public class pair {
        int start;
        int end;
        int room;

        public pair(int start, int end, int room) {
            this.start = start;
            this.end = end;
            this.room = room;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cnt = new int[n];

        // Tracks ongoing meetings: min-heap by end time (and room number to break ties)
        PriorityQueue<pair> q1 = new PriorityQueue<>((a, b) -> {
            if (a.end == b.end) return a.room - b.room;
            return a.end - b.end;
        });

        // Tracks available room numbers: always assign smallest available room
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int k = 0; k < n; k++) {
            available.add(k);
        }

        int j = 0;
        while (j < meetings.length) {
            // Free up rooms that have ended by current meeting's start
            while (!q1.isEmpty() && q1.peek().end <= meetings[j][0]) {
                available.add(q1.poll().room);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                int start = meetings[j][0];
                int end = meetings[j][1];
                q1.add(new pair(start, end, room));
                cnt[room]++;
                j++;
            } else {
                // Delay the meeting to start after the earliest ending meeting
                pair a = q1.poll();
                int duration = meetings[j][1] - meetings[j][0];
                int newEnd = a.end + duration;
                q1.add(new pair(a.end, newEnd, a.room));
                cnt[a.room]++;
                j++;
            }
        }

        // Find the room with the maximum bookings
        int min = 0;
        int num = 0;
        for (int k = 0; k < cnt.length; k++) {
            System.out.print(cnt[k]); // Optional: for debugging
            if (cnt[k] > num) {
                num = cnt[k];
                min = k;
            }
        }
        return min;
    }
}
