class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // reverse order means maximum is at root note

        if(stones.length == 1){
            return stones[0];
        }

        for(int st:stones){
            maxHeap.add(st);
        }

        while (maxHeap.size() > 1) {
            int res = maxHeap.poll() - maxHeap.poll();
            maxHeap.add(res);
        }
        return maxHeap.poll();
    }
}
