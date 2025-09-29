package Day_3;

public class LC_1672_Richest_customer_wealth {
    public int maximumWealth(int[][] accounts) {
        int maxSum = 0;
        for(int i=0; i<accounts.length; i++){
            int rowSum = 0;
            for(int j=0; j<accounts[0].length; j++){
                rowSum+=accounts[i][j];
            }
            maxSum = Math.max(maxSum, rowSum);
        }
        return maxSum;
    }
}