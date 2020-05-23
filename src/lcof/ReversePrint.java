package lcof;
/**
 *输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

import utils.ListNode;

/**
 * xxzuo
 * 面试题06. 从尾到头打印链表
 * 2020/5/23
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        if(head == null){
            return new int[0];
        }
        int len = 1;
        while(node.next != null){
            len++;
            node = node.next;
        }
        int[] res = new int[len];
        for(int i = len - 1;i >= 0;i--){
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}
