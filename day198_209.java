class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, windowSum = 0;
        int result = nums.length + 1;

        while (right < nums.length) {
            windowSum += nums[right++];
            while (windowSum >= target && left < right) {
                result = Math.min(result, right - left);
                windowSum -= nums[left++];
            }
        }

        return result > nums.length ? 0 : result;
    }
}