import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        
        int n = nums.length;
        int maxSum = 0;
        
        //  smallest with the largest
        for (int i = 0; i < n / 2; i++) {
            int pairSum = nums[i] + nums[n - 1 - i];
            maxSum = Math.max(maxSum, pairSum);
        }
        
        return maxSum;
    }
}