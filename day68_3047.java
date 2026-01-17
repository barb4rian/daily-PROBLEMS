class Solution {
    public long largestSquareArea(int[][] b, int[][] t) {
        int n = b.length;
        long a = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = Math.max(b[i][0], b[j][0]);
                int x2 = Math.min(t[i][0], t[j][0]);
                int y1 = Math.max(b[i][1], b[j][1]);
                int y2 = Math.min(t[i][1], t[j][1]);
                
                if (x1 < x2 && y1 < y2) {
                    int s = Math.min(x2 - x1, y2 - y1);
                    a = Math.max(a, (long)s * s);
                }
            }
        }
        
        return a;
    }
}