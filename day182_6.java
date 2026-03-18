class Solution 
{
    public String convert(String s, int r) 
    {
        if (r == 1 || s.length() <= r) return s;

        StringBuilder[] row = new StringBuilder[r];
        for (int i = 0; i < r; i++) row[i] = new StringBuilder();

        int cur = 0;
        boolean down = true;

        for (char c : s.toCharArray()) 
        {
            row[cur].append(c);
            if (cur == 0) down = true;
            else if (cur == r - 1) down = false;
            cur += down ? 1 : -1;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : row) ans.append(sb);
        return ans.toString();
    }
}
