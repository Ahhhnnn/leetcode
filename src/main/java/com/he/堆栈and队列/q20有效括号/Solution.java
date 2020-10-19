package com.he.堆栈and队列.q20有效括号;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        String s = "{{}}{}[](){]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    private static boolean isValid(String s) {
        if(s.length() % 2 ==1){
            return false;
        }
        Map<Character,Character> map = new HashMap<Character, Character>(){
            {
                put(')','(');
                put(']','[');
                put('}','{');
            }
        };
        Deque<Character> stack = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果为有括号，需要和左括号匹配
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
