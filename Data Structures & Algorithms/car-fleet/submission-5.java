class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // hash map position, speed
        // fleet ++ 
        // fleet -- previous is less or same

        int[][] pair = new int[position.length][2];
        int n = position.length;

        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(a[0], b[0]));

        int fleets = 0;
        double slowestTimeAhead = 0.0;
        for (int i = n - 1; i >= 0; i--) {
            // Must cast to double BEFORE division to avoid integer truncation
            double time = (double) (target - pair[i][0]) / pair[i][1];
            
            // If it takes longer than the fleet ahead, it can't catch up.
            // It forms a new fleet and sets the new bottleneck time.
            if (time > slowestTimeAhead) {
                fleets++;
                slowestTimeAhead = time;
            }
        }

        return fleets;
    }
}

//0,1,4,7
//1,2,2,1
//10,4.5,3,3

