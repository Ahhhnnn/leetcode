//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 122 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
     public static void main(String[] args) {  
         //测试代码  
         Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
         int [] nums = {1,2,3,4};
         int[] exchange = solution.exchange(nums);
         System.out.println(exchange);
     }
//力扣代码  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        // 左右指针
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 左指针向右移动，寻找偶数
            if (nums[left] % 2 != 0) {
                left ++;
                continue;
            }

            if (nums[right] % 2 == 0) {
                right --;
                continue;
            }
            // 交换 left  和 right的值
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
} 