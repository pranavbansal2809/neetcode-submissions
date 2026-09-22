class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Step 1: Find the pivot (the index of the minimum element)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // When the loop ends, 'left' is the index of our pivot.
        int pivot = left; 
        
        // Step 2: Figure out which half of the array to search
        left = 0;
        right = nums.length - 1;
        
        // If target is between the pivot and the very end, it's in the right half
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            // Otherwise, it must be in the left half
            right = pivot - 1;
        }

        // Step 3: Standard Binary Search on that specific half
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }
}