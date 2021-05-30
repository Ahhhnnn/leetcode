package zijie;


import java.util.Arrays;

public class leet300最长递增子序列 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet300最长递增子序列().new Solution();

    }


    /**
     * 描述：最长递增子序列
     * 搞不懂。。。
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int res = 0;
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }

}
