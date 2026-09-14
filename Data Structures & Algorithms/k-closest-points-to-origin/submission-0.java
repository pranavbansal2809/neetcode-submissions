class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int res[][] = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            int dist1 = p2[0] * p2[0] + p2[1] * p2[1];
            int dist2 = p1[0] * p1[0] + p1[1] * p1[1];
            return Integer.compare(dist1, dist2);
        });


        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
                
            if(pq.size()>k){
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
