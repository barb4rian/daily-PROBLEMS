class Solution 
{
    public int minOperations(int[] nums) 
    {
        int n = nums.length,
        c = 0, o = 0;
        for (int x : nums) 
        if (x == 1) c++;
        if (c > 0) 
        return n - c;

        int g = 0, ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) 
        {
            g = nums[i];
            for (int j = i + 1; j < n; j++) 
            {
                g = gcd(g, nums[j]);
                if (g == 1) 
                {
                    ans = Math.min(ans, j - i);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans + n - 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
