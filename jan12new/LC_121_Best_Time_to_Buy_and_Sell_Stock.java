package jan12new;

public class LC_121_Best_Time_to_Buy_and_Sell_Stock {
    // Readable but slower
    class Solution {
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

    // Faster, skips calculating profit when we find minimum price, price - minprice = 0, no benefit
    class Solution2 {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int maxprof = 0;
            for(int price: prices){
                if(price<min) min = price;
                else maxprof = Math.max(maxprof, price-min);
            }
            return maxprof;
        }
    }

}
