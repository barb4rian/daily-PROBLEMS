class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            
            if (num == 2) {
                ans[i] = -1;
                continue;
            }
            
            // Find rightmost 0 bit in num
            int pos = 0;
            while ((num & (1 << pos)) != 0) {
                pos++;
            }
            
            // Turn off the bit just before rightmost 0
            ans[i] = num & ~(1 << (pos - 1));
        }
        
        return ans;
    }
}