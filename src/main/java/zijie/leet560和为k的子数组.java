package zijie;


import java.util.HashMap;
import java.util.Map;

public class leet560和为k的子数组 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet560和为k的子数组().new Solution();

    }


    /**
     * 描述：
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {
            //return extracted(nums, k);

            // hahs表优化
            Map<Integer, Integer> map = new HashMap<>();
            // 和为0 出现一次
            map.put(0, 1);
            int pre = 0;
            int count = 0;
            for (int num : nums) {
                pre += num;
                // 存在pre - k的值，（说明之前有和为pre - k 的连续子数组）
                // 说明加上上面的num，就是 = k，次数加1
                if (map.containsKey(pre - k)) {
                    count += map.get(pre - k);
                }
                // put
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return count;
        }

        /**
         * 枚举法，每次逆向查找是否有和为k的数组，如果查找到了就+1，然后继续找，因为有可能存在负数，还有可能和为k
         * @param nums
         * @param k
         * @return
         */
        private int extracted(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum += nums[j];
                    if (sum == k) {
                        count ++;
                    }
                }
            }
            return count;
        }
    }

}
