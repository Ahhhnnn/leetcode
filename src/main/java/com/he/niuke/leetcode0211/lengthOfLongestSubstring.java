package com.he.niuke.leetcode0211;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|";
        int result=lengthOfLongestString(s);
        System.out.println(result);
    }

    private static int lengthOfLongestString(String s){
        int sum=0;
        char[] chars=s.toCharArray();
        List<String> subString= new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            String chari=new String(new char[]{chars[i]});
            //如果temp中不含此元素，则不重复，加入子串后方
            if(!temp.contains(chari)){
                temp.add(chari);
                subString.add(chari);
            }else {
                //判断此时子串的长度，如果> sum 赋值给sum，如果<sum 不赋值
                if(subString.size()>sum){
                    sum=subString.size();
                }
                //得到重复元素的下标
                int index = temp.indexOf(chari);
                //将此下标之前的数据从subString中去除
                subString=subString.subList(index+1,subString.size());
                temp.clear();
                subString.add(chari);
                //将子串的全部元素加入temp中，用以判断是否重复
                temp.addAll(subString);
            }
            //最后一个元素时，判断此时的子串长度是否比sum大
            if(i==chars.length-1){
                if(subString.size()>sum){
                    sum = subString.size();
                }
            }
        }
        return sum;
        /*//如果s为空，length不大于0，是一个空串，就没有向下执行的必要了
        if(s != null && s.length() > 0 && s != ""){
            //String -> char[]
            char[] strChar = s.toCharArray();
            // 存储最长字串 key:char值，value:index下标
            ArrayList<String> maxStr = new ArrayList<>();
            //临时的字串存储空间
            ArrayList<String> tempStr = new ArrayList<>();
            //循环
            for(int i=0; i<strChar.length; i++){
                //char -> String
                String str = new String(new char[]{strChar[i]});
                //判断str是否存在于tempStr中
                if(tempStr.contains(str)){
                    //先判断tempStr的长度是否大于等于maxStr的长度,大于，才能将最长字串覆盖
                    if(tempStr.size() > maxStr.size()){
                        maxStr = new ArrayList<>(tempStr);
                    }
                    //存储重复字符
                    int reIndex = tempStr.indexOf(str);
                    // 删除tempStr中的重复字节及其之前的字符
                    for(int j=0;j<=reIndex;j++){
                        tempStr.remove(0);
                    }
                }
                //将当前字符存入tempStr中
                tempStr.add(str);
            }
            //最终判断
            if(tempStr.size() > maxStr.size()){
                maxStr = tempStr;
            }
            //返回最长字串的长度
            return maxStr.size();
        }
        return 0;*/
    }
}
