package zijie;


public class leet322零钱兑换 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet322零钱兑换().new Solution();
        int[] coins = new int[]{1,2,5};
        int i = solution.coinChange(coins, 11);
        System.out.println(i);
    }


    /**
     * 描述：零钱兑换
     */
    class Solution {
        int res = Integer.MAX_VALUE;
        public int coinChange(int[] coins, int amount) {
            // 递归法，超出时间限制
            if (coins.length <= 0) {
                return res;
            }
            find(coins, amount ,0);
            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            return res;
        }


        // 记忆化搜索
        // TODO

        public void find(int[] coins, int amount, int count) {
            if (amount < 0) {
                return;
            }
            // 刚好兑换完成
            if (amount == 0) {
                res = Math.min(res, count);
            }
            for (int coin : coins) {
                find(coins, amount - coin, count + 1);
            }
        }
    }

}
