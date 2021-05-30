package zijie;


public class leet415字符串相加 {
    public static void main(String[] args) {
        //测试代码  
        Solution solution = new leet415字符串相加().new Solution();
        String nums = "19";
        String nums1 = "123";
        String s = solution.addStrings(nums, nums1);
        System.out.println(s);
    }


    /**
     * 描述：字符串相加
     */
    class Solution {
        public String addStrings(String num1, String num2) {
            int i = num1.length() -1;
            int j = num2.length() -1;
            // 是否进位
            int add = 0;
            StringBuilder result = new StringBuilder();
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int res = x + y + add;
                // re
                result.append(res % 10);
                add = res / 10;
                i--;
                j--;
            }
            result.reverse();
            return result.toString();
        }
    }

}
