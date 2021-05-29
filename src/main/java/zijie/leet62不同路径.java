package zijie;


import java.util.Arrays;

public class leet62不同路径 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet62不同路径().new Solution();
        /*
         * [1,1]
         * [1,2]
         * [1,3]
         * 走到每个位置有对应数字种走法
         */
        int i = solution.uniquePaths(3, 2);
        System.out.println(i);
    }


    /**
     * 3. 所有路径
     */
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }

        /*
          减少空间，压缩空间
          只在一维数组上进行增加
         */
        public int uniquePaths2(int m, int n) {
            int[] cur = new int[n];
            Arrays.fill(cur,1);
            for (int i = 1; i < m;i++){
                for (int j = 1; j < n; j++){
                    cur[j] += cur[j-1] ;
                }
            }
            return cur[n-1];
        }


    }

}
