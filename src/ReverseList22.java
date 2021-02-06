/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName ReverseList22.java
 * @Description 反转链表
 * @createTime 2021年02月06日 14:02:00
 */
public class ReverseList22 {

    public static ListNode reverseList(ListNode head) {
        // 思路是遍历当前链表 实现头插法创建新链表
        // 伪节点
        ListNode node = new ListNode(-1);
        ListNode p;
        // 头插法
        while (head != null){
            p = new ListNode(head.val);
            p.next = node.next;
            node.next = p;
            head = head.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode head = new ListNode(-1);
        ListNode p = SingleLinkedList.createTail(array, head);
        ListNode res = reverseList(p);
        SingleLinkedList.print(res);
    }
}
