class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;
        int ans = n, mis0 = 0;
        for (int i = 0; i < 2 * n; i++) {
            char exp0 = (i % 2 == 0) ? '0' : '1';
            if (t.charAt(i) != exp0) mis0++;
            if (i >= n) {
                int left = i - n;
                char expL = (left % 2 == 0) ? '0' : '1';
                if (t.charAt(left) != expL) mis0--;
            }
            if (i >= n - 1)
                ans = Math.min(ans, Math.min(mis0, n - mis0));
        }
        return ans;
    }
}