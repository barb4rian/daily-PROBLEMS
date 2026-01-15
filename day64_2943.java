import java.util.Arrays;
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = findMaxConsecutive(hBars);
        int maxV = findMaxConsecutive(vBars);
        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }
    
    private int findMaxConsecutive(int[] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr);
        int max = 1;
        int cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
        }
        return max;
    }
}