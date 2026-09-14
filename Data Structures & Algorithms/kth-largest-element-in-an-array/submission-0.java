class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int req = nums.length - k + 1;

        for(int n:nums){
            maxHeap.add(n);
            if(maxHeap.size()> req){
                maxHeap.poll();
            }
        }        

        return maxHeap.poll();
    }
}

// 1,2,3,4,5
// 1,1,2,3,4,5,5

