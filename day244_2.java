public class Solution {
    public int maxDistance(int S, int[][] P, int K) {
        int n = P.length;
        long l = 4L * S;
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            int x = P[i][0], y = P[i][1];
            long p;
            if (y == 0)
                p = x;
            else if (x == S)
                p = S + y;
            else if (y == S)
                p = 2L * S + (S - x);
            else
                p = 3L * S + (S - y);
            a[i] = p;
        }

        Arrays.sort(a);
        long[] b = new long[2 * n];

        for (int i = 0; i < n; i++) {
            b[i] = a[i];
            b[i + n] = a[i] + l;
        }

        return X.y(a, b, K, l);
    }

    private static class X {
        static boolean z(long d, long[] a, long[] b, int K, long l) {
            int n = a.length;
            int m = 2 * n;
            int[] c = new int[m];
            Arrays.fill(c, m);

            for (int i = 0; i < m; i++) {
                long t = b[i] + d;
                int j = lowerBound(b, t);
                c[i] = j;
            }

            int L = 32;
            int[][] jmp = new int[L][m];

            for (int i = 0; i < m; i++) {
                jmp[0][i] = c[i];
            }
            for (int j = 1; j < L; j++) {
                for (int i = 0; i < m; i++) {
                    int ni = jmp[j - 1][i];
                    jmp[j][i] = (ni < m) ? jmp[j - 1][ni] : m;
                }
            }

            for (int i = 0; i < n; i++) {
                int cur = i;
                int r = K - 1;
                for (int j = 0; j < L; j++) {
                    if (((r >> j) & 1) == 1) {
                        cur = jmp[j][cur];
                        if (cur >= i + n)
                            break;
                    }
                }
                if (cur < i + n && (b[i] + l - b[cur] >= d)) {
                    return true;
                }
            }
            return false;
        }

        static int y(long[] a, long[] b, int K, long l) {
            long lo = 0, hi = 2L * l, ans = 0;
            while (lo <= hi) {
                long mid = (lo + hi) / 2;
                if (z(mid, a, b, K, l)) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return (int) ans;
        }

        private static int lowerBound(long[] array, long value) {
            int left = 0, right = array.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (array[mid] < value)
                    left = mid + 1;
                else
                    right = mid;
            }
            return left;
        }
    }
}