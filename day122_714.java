class Solution {
    public int maxProfit(int[] prices, int fee) {
        int maxProfit = 0;
        int priceslen = prices.length;
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < priceslen; i++) {
            if (prices[i] < mini) {
                mini = prices[i];
            } 
            else if (prices[i] - mini > fee) {
                maxProfit += prices[i] - mini - fee;
                mini = prices[i] - fee;
            }
        }
        return maxProfit;
    }
}