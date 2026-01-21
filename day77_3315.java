class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            
            if (x == 2) {
                ans[i] = -1;
                continue;
            }
            
            // Find first 0 bit from right
            int pos = 0;
            while ((x & (1 << pos)) != 0) {
                pos++;
            }
            
            // Clear bit at (pos - 1)
            ans[i] = x & ~(1 << (pos - 1));
        }
        
        return ans;
    }
}