class Solution {
    public double separateSquares(int[][] squares) {
        // Collect all critical y-positions
        List<Double> positions = new ArrayList<>();
        for (int[] sq : squares) {
            positions.add((double) sq[1]);           // bottom
            positions.add((double) sq[1] + sq[2]);   // top
        }
        
        // Sort and remove duplicates
        Collections.sort(positions);
        
        // Binary search through these positions
        double left = positions.get(0);
        double right = positions.get(positions.size() - 1);
        double eps = 1e-6;
        
        while (right - left > eps) {
            double mid = (left + right) / 2.0;
            
            double totalArea = 0.0;
            double areaBelow = 0.0;
            
            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];
                totalArea += l * l;
                
                if (mid <= y) {
                    // All above
                } else if (mid >= y + l) {
                    // All below
                    areaBelow += l * l;
                } else {
                    // Partially below
                    areaBelow += l * (mid - y);
                }
            }
            
            if (areaBelow * 2 < totalArea) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}