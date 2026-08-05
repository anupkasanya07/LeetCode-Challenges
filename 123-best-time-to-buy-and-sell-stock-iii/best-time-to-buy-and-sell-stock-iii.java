class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        int firstProfit = 0;
        int secondBuy = Integer.MAX_VALUE;
        int secondProfit = 0;

        for (int price : prices) {
            // First transaction
            firstBuy = Math.min(firstBuy, price);
            firstProfit = Math.max(firstProfit, price - firstBuy);

            // Second transaction (using profit from first transaction to offset cost)
            secondBuy = Math.min(secondBuy, price - firstProfit);
            secondProfit = Math.max(secondProfit, price - secondBuy);
        }

        return secondProfit;
    }
}