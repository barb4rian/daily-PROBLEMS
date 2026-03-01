class Solution 
{
    public int majorityElement(int[] nums) 
    {
        int c = 0, v = 0; 
        for (int x : nums) 
        {
            if (c == 0) v = x;
            c += (x == v) ? 1 : -1;
        }
        return v;
    }
}