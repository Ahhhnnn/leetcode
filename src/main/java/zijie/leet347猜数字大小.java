package zijie;


public class leet347猜数字大小 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet347猜数字大小().new Solution();

    }


    /**
     * 描述：猜数字大小 二分查找
     */
    class Solution {
        public int guessNumber(int n) {
            int left = 1, right = n;
            while (left < right) { // 循环直至区间左右端点相同
                int mid = left + (right - left) / 2; // 防止计算时溢出
                if (guess(mid) <= 0) {// 选出的数字比你猜的数字小，在左区间
                    right = mid; // 答案在区间 [left, mid] 中
                } else {
                    left = mid + 1; // 答案在区间 [mid+1, right] 中
                }
            }
            // 此时有 left == right，区间缩为一个点，即为答案
            return left;
        }

        private int guess(int mid) {
            return 0;
        }
    }
}
