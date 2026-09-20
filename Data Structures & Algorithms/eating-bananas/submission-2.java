class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // binary search on min and max value of k
        // min beng 1 and max being max or array

        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        int k = (right + left)/2, ans = right;
        int time = 0;

        while(left<=right){
            // calculate time to eat pile
            for(int i=0;i<piles.length;i++){
                time+=(int)Math.ceil((double)piles[i]/k);
            }
            if(time>h){
                left = k+1;
            }else{
                right = k-1;
                ans = k;
            }
            k=(right + left)/2;
            time = 0;
        }
        return ans;
    }
}
// 
// left = 19
// right = 25
// k = 19
// time = 6

