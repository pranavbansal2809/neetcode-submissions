class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Start and end pointers for our "flat" array
        int left = 0;
        int right = (rows * cols) - 1; 
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            // Translate the 1D 'mid' index back into 2D grid coordinates
            int midValue = matrix[mid / cols][mid % cols];
            
            if (midValue == target) {
                return true;          // Found it!
            } else if (midValue < target) {
                left = mid + 1;       // Target is bigger, search right half
            } else {
                right = mid - 1;      // Target is smaller, search left half
            }
        }
        
        return false; // Target is not in the matrix
    }
}