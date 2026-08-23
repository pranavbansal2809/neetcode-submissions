class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Keep a Min-Heap of size K (ordered by frequency)
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
        );
        
        for (int num : count.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll(); // Evict the smallest frequency
            }
        }

        // Step 3: Extract the top K elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
