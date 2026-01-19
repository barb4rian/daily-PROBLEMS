class Solution {
    public int maxSideLength(int[][] m, int t) {
        int r = m.length, c = m[0].length;
        int[][] p = new int[r+1][c+1];
        
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                p[i][j] = m[i-1][j-1] + p[i-1][j] + p[i][j-1] - p[i-1][j-1];
            }
        }
        
        int ans = 0;
        
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int maxS = Math.min(i, j);
                for (int s = ans + 1; s <= maxS; s++) {
                    int sum = p[i][j] - p[i-s][j] - p[i][j-s] + p[i-s][j-s];
                    if (sum <= t) {
                        ans = s;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}