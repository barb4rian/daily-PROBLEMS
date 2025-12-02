import java.util.*;

class Solution {
    public int countTrapezoids(int[][] p) {
        long m = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] pt : p) map.put(pt[1], map.getOrDefault(pt[1], 0) + 1);
        
        List<Integer> ys = new ArrayList<>(map.keySet());
        Collections.sort(ys);
        
        long[] h = new long[ys.size()];
        for (int i = 0; i < ys.size(); i++) { long c = map.get(ys.get(i)); h[i] = c * (c - 1) / 2; }
        
        long pre = 0, ans = 0;
        for (long val : h) { ans = (ans + pre * (val % m)) % m;       pre = (pre + val) % m; }
        
        return (int) ans;
    }
}