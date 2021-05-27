package zijie;


import java.util.HashMap;
import java.util.Map;

public class leet1两数之和 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet1两数之和().new Solution();
        int[] nums =  new int[]{2,7,11,15};
        int[] ints = solution.twoSum(nums, 13);
        System.out.println(ints);
    }


    /**
     * 3. 无重复字符的最长子串
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }

}
