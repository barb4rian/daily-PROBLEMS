class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int n = strs.length;
        
     
        for (int col = 0; col < strs[0].length(); col++) {
        
            for (int row = 1; row < n; row++) {
                if (strs[row].charAt(col) < strs[row-1].charAt(col)) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}