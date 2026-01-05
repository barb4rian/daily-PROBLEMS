public long maxMatrixSum(int[][] matrix) {
    int leastElement = Integer.MAX_VALUE;  
    long sum = 0L;
    int negativeCount = 0;

    for(int[] rows : matrix){
        for(int value : rows){
            if(value < 0){
                negativeCount++;
                value = -value;
            }
            sum += value;
            if(value < leastElement){
                leastElement = value;
            }
        }
    }
    
 
    return (negativeCount % 2 == 0) ? sum : sum - 2L * leastElement;
}