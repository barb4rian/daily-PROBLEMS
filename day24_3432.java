class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        long tot = 0;
        
        //  total sum
        for (int x : nums) {
            tot += x;
        }
        
        int cnt = 0;
        long left = 0;
        
        // Try each partition point
        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            long right = tot - left;
            long diff = left - right;
            
             //difference is even
            if (diff % 2 == 0) {
                cnt++;
            }
        }
        
        return cnt;
    }
}