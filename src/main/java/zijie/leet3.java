package zijie;


import java.util.LinkedList;
import java.util.Queue;

public class leet3 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet3().new Solution();
        String s = "abcabcbb";
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }


    /**
     * 3. 无重复字符的最长子串
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            Queue<Character> queue = new LinkedList<>();
            for (char c : s.toCharArray()) {
               while (queue.contains(c)) {
                   queue.poll();
               }
               queue.offer(c);
               if (queue.size() > max) {
                   max = queue.size();
               }
            }
            return max;
        }
    }

}
