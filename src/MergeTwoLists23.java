import java.util.List;

/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName MergeTwoLists23.java
 * @Description 合并两个排序的链表
 * @createTime 2021年02月06日 16:56:00
 */
public class MergeTwoLists23 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 伪节点
        ListNode node = new ListNode(-1);
        ListNode head = node;
        ListNode p;
        // 尾插法实现
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                p = new ListNode(l2.val);
                l2 = l2.next;
            }
            node.next = p;
            node = p;
        }
        // 剩余的都接上
        while (l1 != null){
            p = new ListNode(l1.val);
            node.next = p;
            node = p;
            l1 = l1.next;
        }
        while (l2 != null){
            p = new ListNode(l2.val);
            node.next = p;
            node = p;
            l2 = l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 4};
        int[] array2 = {1, 3, 4};
        ListNode node = new ListNode(-1);
        ListNode l1 = SingleLinkedList.createTail(array1, node);
        ListNode l2 = SingleLinkedList.createTail(array2, node);
        ListNode res = mergeTwoLists(l1, l2);
        SingleLinkedList.print(res);
    }
}
