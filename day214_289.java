class Solution {
    public void gameOfLife(int[][] b) {
        int m = b.length, n = b[0].length;

        int[] d = {-1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int c = 0;
                for (int x : d) {
                    for (int y : d) {
                        if (x == 0 && y == 0) continue;

                        int r = i + x, s = j + y;

                        if (r >= 0 && r < m && s >= 0 && s < n) {
                            if (Math.abs(b[r][s]) == 1) c++;
                        }
                    }
                }
                if (b[i][j] == 1 && (c < 2 || c > 3)) {
                    b[i][j] = -1;
                }

                if (b[i][j] == 0 && c == 3) {
                    b[i][j] = 2; 
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] > 0) b[i][j] = 1;
                else b[i][j] = 0;
            }
        }
    }
}