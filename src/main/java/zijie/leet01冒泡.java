package zijie;


public class leet01冒泡 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet01冒泡().new Solution();
        int[] nums = new int[] {12, 2, 22, 47, 26, 8};
        solution.maopao(nums);
        System.out.println(nums);
    }


    /**
     * 描述：
     */
    class Solution {
        public void maopao (int[] nums) {
            int length = nums.length;
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - 1 - i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j + 1];
                        nums[j + 1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }

}
