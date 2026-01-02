class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int x : arr) 
            count[x + 1000]++;
        
        boolean[] seen = new boolean[1001];
        for (int c : count) {
            if (c > 0) {
                if (seen[c]) return false;
                seen[c] = true;
            }
        }
        return true;
    }
}