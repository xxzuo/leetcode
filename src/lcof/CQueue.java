package lcof;

import java.util.Stack;
/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * xxzuo
 * 面试题09. 用两个栈实现队列
 * 2020/5/23
 */
class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;


    public CQueue() {
        //初始化栈
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }

    public void appendTail(int value) {
        //插入栈1前先将栈1元素全部依次弹出到栈2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //将新插入元素放入栈底
        stack1.push(value);
        //栈的size增加
        size++;
        //再将栈2的元素依次弹回栈1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        //判断size，如果为0则是空栈，返回-1
        //否则弹出栈1最上面的元素，同时size减少
        if(size == 0){
            return -1;
        }else{
            size--;
            return stack1.pop();
        }

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
