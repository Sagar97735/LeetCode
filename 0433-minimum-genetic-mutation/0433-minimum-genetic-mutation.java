import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;

        char[] mutations = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) return level;

                char[] geneArr = curr.toCharArray();
                for (int j = 0; j < geneArr.length; j++) {
                    char oldChar = geneArr[j];
                    for (char c : mutations) {
                        if (c == oldChar) continue;
                        geneArr[j] = c;
                        String newGene = new String(geneArr);
                        if (bankSet.contains(newGene)) {
                            queue.add(newGene);
                            bankSet.remove(newGene);
                        }
                    }
                    geneArr[j] = oldChar;
                }
            }
            level++;
        }
        return -1;
    }
}
