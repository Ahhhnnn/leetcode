//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 212 👎 0


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

class 最小的k个数{
    public static void main(String[] args) {
        Solution solution = new 最小的k个数().new Solution();
        // TO TEST
        int[] result = {3,2,1};
        int[] leastNumbers = solution.getLeastNumbers(result, 2);
        for (int leastNumber : leastNumbers) {
            System.out.println(leastNumber);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i : arr) {
            queue.offer(i);
        }
        System.out.println(queue);
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        System.out.println(result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}