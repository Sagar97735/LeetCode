class Solution {  
    public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;  
        if (low >= high) return cnt;

        int mid = (low + high) / 2; 
        // Left half ke pairs count karo
        cnt += mergeSort(arr, low, mid);
        // Right half ke pairs count karo
        cnt += mergeSort(arr, mid + 1, high);
        // Ab dono halves ke beech ke pairs count karo
        cnt += countPairs(arr, low, mid, high);
        // Ab merge kar do dono sorted halves ko ek sorted array me
        merge(arr, low, mid, high);

        return cnt; // total pairs return karo
    }

    // Merge function: typical merge sort merge step
    public void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary list for merged result

        int left = low;       // left pointer
        int right = mid + 1;  // right pointer

        // dono halves ko merge karte waqt sort maintain karo
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // agar left half me elements bache ho
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // agar right half me elements bache ho
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // merged elements ko original array me daal do
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

   public static int countPairs(int[] arr, int low, int mid, int high) {
    int right = mid + 1;
    int cnt = 0;
    for (int i = low; i <= mid; i++) {
        // Convert to long to avoid integer overflow
        while (right <= high && (long)arr[i] > 2L * (long)arr[right]) right++;
        cnt += (right - (mid + 1));
    }
    return cnt;
}


    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
}
