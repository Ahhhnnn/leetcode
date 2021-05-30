package zijie;


import java.util.Arrays;

public class leet88合并两个有序数组 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet88合并两个有序数组().new Solution();

    }


    /**
     * 描述：合并两个有序数组
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 合并排序法
//            for (int i = 0; i != n; ++i) {
//                nums1[m + i] = nums2[i];
//            }
//            Arrays.sort(nums1);

            // 双指针
            int p1 = 0, p2 =0;
            int cur;
            int[] result = new int[m + n];
            while (p1 < m || p2 < n) {
                if (p1 == m) {
                    cur = nums2[p2++];
                } else if (p2 == n) {
                    cur = nums1[p1++];
                } else if (nums1[p1] < nums2[p2]) {
                    cur = nums1[p1++];
                } else {
                    cur = nums2[p2++];
                }
                result[p1 + p2 - 1] = cur;
            }
            for (int i = 0; i < result.length; i++) {
                nums1[i] = result[i];
            }
        }
    }

}
