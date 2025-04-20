class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        for (int key : map.keySet()) {
            int count = map.get(key);
            int groupSize = key + 1;
            // Number of groups needed (ceil(count / groupSize))
            int groups = (count + groupSize - 1) / groupSize;
            res += groups * groupSize;
        }

        return res;
    }
}
