class Solution {
    int[] parent = new int[26];

    // Find root of character x
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union two characters, keeping the smaller one as the root
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;

        // Always keep the smaller char as the representative
        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize each character as its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union all equivalent characters
        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            union(a, b);
        }

        // Build the final result using the smallest representative for each char
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            int root = find(c - 'a');
            ans.append((char)(root + 'a'));
        }

        return ans.toString();
    }
}
