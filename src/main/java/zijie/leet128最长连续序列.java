package zijie;


import java.util.*;

public class leet128最长连续序列 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet128最长连续序列().new Solution();
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int i = solution.longestConsecutive(nums);
        System.out.println(i);
    }


    /**
     * 描述：
     */
    class Solution {
        public int longestConsecutive(int[] nums) {
            //return extracted(nums);
            // 外层循环剪枝
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int longest = 0;
            for (int num : nums) {
                // 不存在num - 1 在判断
                // 如果存在num - 1，那么之后找到num -1 这个数字后，一定会到当前这个数字，不用这个时候进行判断
                // 如果不存在 num - 1 说明当前这个数就是这个最长连续序列的开头
                if (!set.contains(num - 1)) {
                    int curlength = 1;
                    while (set.contains(num + 1)) {
                        curlength ++;
                        num ++;
                    }
                    longest = Math.max(longest, curlength);
                }
            }
            return longest;
        }

        // 枚举法
        // 会超时，一直枚举 是否存在数等于 x + 1
        private int extracted(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int longest = 0;
            // 去重
            for (int num : nums) {
                set.add(num);
            }
            for (Integer integer : set) {
                int currLength = 0;
                while (set.contains(integer)) {
                    currLength++;
                    integer++;
                }
                longest = Math.max(longest, currLength);
            }
            return longest;
        }
    }
}
