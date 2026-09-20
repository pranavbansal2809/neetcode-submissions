class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The minimum is strictly to the right of mid
                left = mid + 1;
            } else {
                // The minimum is at mid or to the left of mid
                right = mid;
            }
        }
        
        // When left == right, we have found the minimum element
        return nums[left];
    }
}