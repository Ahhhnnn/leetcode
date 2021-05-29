package zijie;


public class leet76最小覆盖子串 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = solution.minWindow(s, t);
        System.out.println(s1);
    }


    /**
     * 描述：最小覆盖子串
     */
    static class Solution {
        // 滑动窗口 left，right 双指针移动
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0 || t == null || t.length() == 0) {
                return "";
            }
            // 定义需要的字符的次数
            int[] need = new int[128];
            for (int i = 0; i < t.length(); i++) {
                need[t.charAt(i)]++;
            }
            // 定义参数
            int left = 0;
            int right = 0;
            int size = s.length() + 1;
            int count = t.length();
            int start = 0;

            while (right < s.length()) {
                char c = s.charAt(right);
                // 说明该字符 t 需要
                if (need[c] > 0) {
                    count --;
                }
                need[c] --;
                // ==0 说明已全部满足t的要求
                if (count == 0) {
                    // 移除right移动时，t中不需要的字符统计
                    while (left < right && need[s.charAt(left)] < 0) {
                        need[s.charAt(left)] ++;
                        // 移动左指针
                        left ++;
                    }
                    // 统计长度
                    if (right - left + 1 < size) {
                        size = right - left + 1;
                        // 满足t条件的 开始下标
                        start = left;
                    }
                    // 说明left 指向的字符是 t需要的了，如果移除了，那么一定不满足，count 需要+1
                    need[s.charAt(left)] ++;
                    left ++;
                    count ++;
                }
                right ++;
            }
            return size == s.length() + 1 ? "" : s.substring(start, start + size);
        }
    }

}
