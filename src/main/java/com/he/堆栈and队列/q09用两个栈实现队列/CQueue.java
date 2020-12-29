package com.he.堆栈and队列.q09用两个栈实现队列;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {
    Stack<Integer> A,B;
    public CQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void appendTail(int value) {
        A.push(value);
    }

    public int deleteHead() {
        if(B.empty()){
            while (!A.empty()){
                B.push(A.pop());
            }
        }
        if(B.empty()){
            return -1;
        }
        return B.pop();
    }

    public static void main(String[] args) {
        CQueue c = new CQueue();
        c.appendTail(1);
        c.appendTail(2);
        c.appendTail(3);
        System.out.println(c.deleteHead());
    }
}
