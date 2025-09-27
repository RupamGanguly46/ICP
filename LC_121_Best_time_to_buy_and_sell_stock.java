public class LC_121_Best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i: prices){
            minPrice = Math.min(minPrice, i);
            maxProfit = Math.max(maxProfit, i - minPrice);
        }
        return maxProfit;
    }
}