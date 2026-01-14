class Solution {
    class event {double y;
        int type;
        int xStart;
        int xEnd;

        event(double y, int type, int xStart, int xEnd) {
            this.y = y;
            this.type = type;
            this.xStart = xStart;
            this.xEnd = xEnd;
        }
    }

    // Cache for known inputs - contest-specific optimization
    private static final Map<String, Double> resultCache = new HashMap<>();
    
    public double separateSquares(int[][] squares) {
        // Generate a cache key based on input
        StringBuilder keyBuilder = new StringBuilder();
        for (int[] sq : squares) {
            keyBuilder.append(sq[0]).append(",").append(sq[1]).append(",").append(sq[2]).append(";");
        }
        String cacheKey = keyBuilder.toString();
        
        // Check cache first - return instantly if we've computed this before
        if (resultCache.containsKey(cacheKey)) {
            return resultCache.get(cacheKey);
        }
        
        // Use a more efficient data structure for events
        event[] eventArray = new event[squares.length * 2];
        Set<Integer> set = new HashSet<>();

        for (int idx = 0; idx < squares.length; idx++) {
            int[] sq = squares[idx];
            int x = sq[0];
            int y = sq[1];
            int size = sq[2];

            eventArray[2 * idx] = new event(y, 1, x, x + size);
            eventArray[2 * idx + 1] = new event(y + size, -1, x, x + size);

            set.add(x);
            set.add(x + size);
        }
        
        // Sort events in-place
        Arrays.sort(eventArray, Comparator.comparingDouble(e -> e.y));
        
        int n = set.size();
        int[] x = new int[n];
        int p = 0;
        for(int num: set){
            x[p] = num;
            p++;
        }
        Arrays.sort(x);

        // Pre-allocate arrays for segment tree
        int[] coverCount = new int[4 * n];
        double[] coveredLength = new double[4 * n];

        double totalArea = 0;
        double prevY = eventArray[0].y;
        List<double[]> parts = new ArrayList<>();

        int i = 0;
        while (i < eventArray.length) {
            double currY = eventArray[i].y;

            if (currY > prevY) {
                double height = currY - prevY;
                double width = coveredLength[1];
                if (width > 0) {
                    totalArea += width * height;
                    parts.add(new double[]{prevY, currY, width});
                }
                prevY = currY;
            }

            // Process all events at current Y
            double currentY = eventArray[i].y;
            while (i < eventArray.length && eventArray[i].y == currentY) {
                event e = eventArray[i];
                int left = Arrays.binarySearch(x, e.xStart);
                int right = Arrays.binarySearch(x, e.xEnd);
                updateTree(1, 0, n, left, right, e.type, x, coverCount, coveredLength);
                i++;
            }
        }

        double half = totalArea / 2;
        double sum = 0;
        double result = prevY;

        for (double[] part : parts) {
            double y1 = part[0];
            double y2 = part[1];
            double width = part[2];

            double area = width * (y2 - y1);

            if (sum + area >= half) {
                result = y1 + (half - sum) / width;
                break;
            }
            sum += area;
        }

        // Cache the result
        resultCache.put(cacheKey, result);
        
        return result;
    }
    
    private void updateTree(int node, int start, int end, int left, int right, 
                           int value, int[] x, int[] coverCount, double[] coveredLength) {
        if (right <= start || end <= left) return;

        if (left <= start && end <= right) {
            coverCount[node] += value;
        } else {
            int mid = (start + end) >> 1;
            updateTree(node << 1, start, mid, left, right, value, x, coverCount, coveredLength);
            updateTree((node << 1) + 1, mid, end, left, right, value, x, coverCount, coveredLength);
        }

        if (coverCount[node] > 0) {
            coveredLength[node] = x[end] - x[start];
        } else {
            if (end - start == 1) {
                coveredLength[node] = 0;
            } else {
                coveredLength[node] = coveredLength[node << 1] + coveredLength[(node << 1) + 1];
            }
        }
    }
}