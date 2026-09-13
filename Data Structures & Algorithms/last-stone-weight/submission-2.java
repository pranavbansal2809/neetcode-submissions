class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        if(stones.length == 1){
            return stones[0];
        }

        for(int st:stones){
            maxHeap.add(st);
        }

        while(!maxHeap.isEmpty()){
            int res = maxHeap.poll() - maxHeap.poll();
            if(maxHeap.isEmpty()){
                maxHeap.add(res);
                break;
            }
            maxHeap.add(res);
        }
        return maxHeap.poll();
    }
}
