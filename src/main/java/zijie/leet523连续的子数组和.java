package zijie;


import java.util.HashMap;
import java.util.Map;

public class leet523连续的子数组和 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet523连续的子数组和().new Solution();
        int[] nums = new int[]{23,2,4,6,7};
        boolean b = solution.checkSubarraySum(nums, 6);
        System.out.println(b);
    }


    /**
     * 描述：
     */
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            // 前缀和 + hash表
            int m = nums.length;
            if (m < 2) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(0, -1);
            // 余数
            int remainder = 0;
            for (int i = 0; i < m; i++) {
                // 查询前缀和的余数（当前数的余数加上 前面的余数 = 余数+当前数 % k）
                remainder = (remainder + nums[i]) % k;
                if (map.containsKey(remainder)) {
                    int prevIndex = map.get(remainder);
                    if (i - prevIndex >= 2) {
                        return true;
                    }
                } else {
                    map.put(remainder, i);
                }
            }
            return false;
        }
    }

}
