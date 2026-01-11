class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        
        
        int[] heights = new int[cols];
        
        for (int i = 0; i < rows; i++) {
            // Update heights
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            
            //  each column
            for (int j = 0; j < cols; j++) {
                if (heights[j] > 0) {
                    int minHeight = heights[j];
                    int width = 1;
                    
                    // Expand right
                    for (int k = j + 1; k < cols; k++) {
                        if (heights[k] == 0) break;
                        minHeight = Math.min(minHeight, heights[k]);
                        width++;
                        maxArea = Math.max(maxArea, minHeight * width);
                    }
                    
                    // check  the current column
                    maxArea = Math.max(maxArea, heights[j]);
                }
            }
        }
        
        return maxArea;
    }
}