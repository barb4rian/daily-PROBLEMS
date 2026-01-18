class Solution {
    public int largestMagicSquare(int[][] g) {
        int m = g.length, n = g[0].length;
        int k = Math.min(m, n);
        
        int[][] r = new int[m][n+1];
        int[][] c = new int[m+1][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                r[i][j+1] = r[i][j] + g[i][j];
                c[i+1][j] = c[i][j] + g[i][j];
            }
        }
        
        for (int s = k; s > 1; s--) {
            for (int i = 0; i <= m - s; i++) {
                for (int j = 0; j <= n - s; j++) {
                    if (check(g, i, j, s, r, c)) {
                        return s;
                    }
                }
            }
        }
        return 1;
    }
    
    private boolean check(int[][] g, int r0, int c0, int s, int[][] r, int[][] c) {
        int sum = r[r0][c0+s] - r[r0][c0];
        
        for (int i = 0; i < s; i++) {
            int rs = r[r0+i][c0+s] - r[r0+i][c0];
            int cs = c[r0+s][c0+i] - c[r0][c0+i];
            if (rs != sum || cs != sum) return false;
        }
        
        int d1 = 0, d2 = 0;
        for (int i = 0; i < s; i++) {
            d1 += g[r0+i][c0+i];
            d2 += g[r0+i][c0+s-1-i];
        }
        
        return d1 == sum && d2 == sum;
    }
}