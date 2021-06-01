package zijie;


public class leet01快排 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet01快排().new Solution();
        int[] nums = new int[] {12, 2, 22, 47, 26, 8};
        solution.quickSort(nums, 0, nums.length - 1);
        System.out.println(nums);
    }


    /**
     * 描述：
     */
    class Solution {
        public void quickSort (int[] nums, int begin, int end) {
            if (begin < end) {
                int key = nums[begin]; //基准数
                int i = begin;
                int j = end;
                while (i < j) {
                    while (i < j && nums[j] > key) {
                        j--;
                    }
                    if (i < j) {
                        nums[i] = nums[j];
                        i++;
                    }
                    while (i < j && nums[i] < key) {
                        i++;
                    }
                    if (i < j) {
                        nums[j] = nums[i];
                        j--;
                    }
                }
                nums[i] = key;
                quickSort(nums, begin, i - 1);
                quickSort(nums, i + 1, end);
            }
        }
    }

}
