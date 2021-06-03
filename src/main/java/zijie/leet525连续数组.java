package zijie;


import java.util.HashMap;
import java.util.Map;

public class leet525连续数组 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet525连续数组().new Solution();

    }


    /**
     * 描述：
     */
    class Solution {
        public int findMaxLength(int[] nums) {
            // 可以把 0 看做 -1，转换为求连续子数组和为0的最长子数组
            // [0，1，1，1，0，0]
            // 存储前缀和 及其下标
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int maxLength = 0;
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num == 1) {
                    temp ++;
                } else {
                    temp --;
                }
                if (map.containsKey(temp)) {
                    int preIndex = map.get(temp);
                    maxLength = Math.max(maxLength, i - preIndex);
                } else {
                    map.put(temp, i);
                }
            }
            return maxLength;
        }
    }

}
