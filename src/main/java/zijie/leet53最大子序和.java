package zijie;


public class leet53最大子序和 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet53最大子序和().new Solution();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = solution.maxSubArray(nums);
        System.out.println(i);
    }


    /**
     * 描述：最大子序和
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            //return baoli(nums);
            // 动态规划
            // 初始状态
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 如果前一个数字是负数，那么直接返回 0，因为如果是负数只会对当前最大子序和产生负影响
                nums[i] += Math.max(nums[i - 1], 0);
                res = Math.max(nums[i], res);
            }
            return res;
        }

        private int baoli(int[] nums) {
            int max = 0;
            int l = nums.length;
            for (int i = 0; i < l; i++) {
                int sum = 0;
                for (int j = i; j < l; j++) {
                    sum += nums[j];
                    max = Math.max(sum, max);
                }
            }
            return max;
        }
    }

}
