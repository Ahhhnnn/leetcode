package zijie;


public class leet64最小路径和 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet64最小路径和().new Solution();

    }


    /**
     * 描述：最小路径和
     */
    class Solution {
        public int minPathSum(int[][] grid) {
            if(grid == null || grid.length ==0 || grid[0].length == 0) {
                return 0;
            }
            int rows = grid.length;
            int cloums = grid[0].length;
            int dp[][] = new int[rows][cloums];
            dp[0][0] = grid[0][0];
            // 第一行和第一列的路径和都是固定的
            // 都是上面 或者 下面 的值 加上当前位置的值

            // 第1列赋值
            for (int i = 1; i < rows; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            // 第一行赋值
            for (int i = 1; i < cloums; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cloums; j++) {
                    // 行列的最小值，加上当前的值
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[rows -1][cloums - 1];
        }
    }

}
