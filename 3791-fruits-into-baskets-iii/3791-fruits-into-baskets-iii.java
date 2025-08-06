class Solution {
    public void build(int idx, int l, int r, int[] arr, int[] tree) {
        if (l == r) {
            tree[idx] = arr[l];
            return;
        }

        int mid = (l + r) / 2;
        build(2 * idx + 1, l, mid, arr, tree);
        build(2 * idx + 2, mid + 1, r, arr, tree);

        tree[idx] = Math.max(tree[2 * idx + 1], tree[2 * idx + 2]);
    }

    public boolean place(int idx, int l, int r, int[] tree, int val) {
        if (tree[idx] < val) return false;

        if (l == r) {
            tree[idx] = -1; // use basket
            return true;
        }

        int mid = (l + r) / 2;
        boolean used;

        if (tree[2 * idx + 1] >= val) {
            used = place(2 * idx + 1, l, mid, tree, val);
        } else {
            used = place(2 * idx + 2, mid + 1, r, tree, val);
        }

        tree[idx] = Math.max(tree[2 * idx + 1], tree[2 * idx + 2]);
        return used;
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] tree = new int[4 * n];

        build(0, 0, n - 1, baskets, tree);

        int unplaced = 0;
        for (int fruit : fruits) {
            if (!place(0, 0, n - 1, tree, fruit)) {
                unplaced++;
            }
        }

        return unplaced;
    }
}
