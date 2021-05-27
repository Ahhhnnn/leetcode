package zijie;


import java.util.LinkedList;
import java.util.Queue;

public class leet121买卖股票最佳时机 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet121买卖股票最佳时机().new Solution();

    }


    /**
     * 121 买卖股票最佳时机
     * 只允许买入一次，在未来一天卖出一次
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxPrice = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minPrice ) {
                    minPrice = prices[i];
                } else if (prices[i] - minPrice > maxPrice) {
                    maxPrice = prices[i] - minPrice;
                }
            }
            return maxPrice;
        }

    }

}
