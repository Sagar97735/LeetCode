import java.util.*;

class Solution {
    private int[][] segTree;
    private final int INF = Integer.MAX_VALUE;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        TreeMap<Integer, Queue<Integer>> capacityMap = new TreeMap<>();
        for (int i = 0; i < baskets.length; i++) {
            capacityMap.computeIfAbsent(baskets[i], k -> new LinkedList<>()).add(i);
        }

        if (capacityMap.isEmpty()) {
            return fruits.length;
        }

        List<Integer> sortedCapacities = new ArrayList<>(capacityMap.keySet());
        Map<Integer, Integer> capacityToSortedIndex = new HashMap<>();
        for (int i = 0; i < sortedCapacities.size(); i++) {
            capacityToSortedIndex.put(sortedCapacities.get(i), i);
        }

        int k = sortedCapacities.size();
        
        List<Integer> initialMinIndices = new ArrayList<>();
        for (int capacity : sortedCapacities) {
            initialMinIndices.add(capacityMap.get(capacity).peek());
        }

        segTree = new int[4 * k][2];
        build(1, 0, k - 1, initialMinIndices);

        int unplacedCount = 0;
        
        for (int fruit : fruits) {
            int insertionPoint = Collections.binarySearch(sortedCapacities, fruit);
            if (insertionPoint < 0) {
                insertionPoint = -insertionPoint - 1;
            }

            if (insertionPoint == k) {
                unplacedCount++;
                continue;
            }

            int[] result = query(1, 0, k - 1, insertionPoint, k - 1);
            int bestBasketIndex = result[0];
            int bestCapacitySortedIndex = result[1];

            if (bestBasketIndex == INF) {
                unplacedCount++;
            } else {
                int usedCapacity = sortedCapacities.get(bestCapacitySortedIndex);
                Queue<Integer> indexQueue = capacityMap.get(usedCapacity);
                indexQueue.poll();

                int nextMinIndex = indexQueue.isEmpty() ? INF : indexQueue.peek();
                update(1, 0, k - 1, bestCapacitySortedIndex, nextMinIndex);
            }
        }
        return unplacedCount;
    }

    private int[] minPair(int[] p1, int[] p2) {
        return p1[0] <= p2[0] ? p1 : p2;
    }

    private void build(int node, int start, int end, List<Integer> initialValues) {
        if (start == end) {
            segTree[node] = new int[]{initialValues.get(start), start};
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, initialValues);
        build(2 * node + 1, mid + 1, end, initialValues);
        segTree[node] = minPair(segTree[2 * node], segTree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            segTree[node][0] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (start <= idx && idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        segTree[node] = minPair(segTree[2 * node], segTree[2 * node + 1]);
    }

    private int[] query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return new int[]{INF, -1};
        }
        if (l <= start && end <= r) {
            return segTree[node];
        }
        int mid = start + (end - start) / 2;
        int[] p1 = query(2 * node, start, mid, l, r);
        int[] p2 = query(2 * node + 1, mid + 1, end, l, r);
        return minPair(p1, p2);
    }
}