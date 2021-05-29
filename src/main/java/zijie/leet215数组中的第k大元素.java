package zijie;


import java.util.Arrays;
import java.util.PriorityQueue;

public class leet215数组中的第k大元素 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet215数组中的第k大元素().new Solution();
        int[] nums = new int[]{3,2,1,5,6,4};
        int kthLargest = solution.findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }


    /**
     * 215 数组中第k大元素
     */
    class Solution {
        public int findKthLargest(int[] nums, int k) {
//            Arrays.sort(nums);
//            return nums[nums.length  -k];

            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
            for (int num : nums) {
                queue.add(num);
            }
            for (int i = 0; i < nums.length - k; i++) {
                queue.poll();
            }
            return queue.peek();
        }
    }

}
