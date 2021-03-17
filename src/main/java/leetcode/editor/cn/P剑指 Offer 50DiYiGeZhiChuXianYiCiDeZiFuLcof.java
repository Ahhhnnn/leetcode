//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 80 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class 第一个只出现一次的字符{
    public static void main(String[] args) {
        Solution solution = new 第一个只出现一次的字符().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if(!map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}