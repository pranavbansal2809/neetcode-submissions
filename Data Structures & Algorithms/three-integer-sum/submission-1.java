class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
List<List<Integer>> out = new ArrayList<>();

for (int j = 0; j < nums.length - 2; j++) {
    // Skip duplicate elements for the first number
    if (j > 0 && nums[j] == nums[j - 1]) continue;

    int left = j + 1;
    int right = nums.length - 1;

    while (left < right) {
        int sum = nums[j] + nums[left] + nums[right];

        if (sum == 0) {
            out.add(Arrays.asList(nums[j], nums[left], nums[right]));

            // Skip duplicate elements for the second and third numbers
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right] == nums[right - 1]) right--;

            left++;
            right--;
        } else if (sum < 0) {
            left++; // Need a larger sum
        } else {
            right--; // Need a smaller sum
        }
    }
}
        
        return out;
    }
}
