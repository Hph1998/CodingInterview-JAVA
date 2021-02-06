/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName GetKthFromEnd21.java
 * @Description 链表中倒数第k个节点
 * @createTime 2021年02月06日 13:44:00
 */
public class GetKthFromEnd21 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        // 思路双指针
        ListNode p = head;
        // 让p先走k步
        while (k > 0){
            p = p.next;
            k--;
        }
        // 然后p和head一起走 head永远落后p有k步 直到p走完 head就定位到倒数第k了
        while (p != null){
            head = head.next;
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode head = new ListNode(-1);
        ListNode p = SingleLinkedList.createTail(array, head);
        ListNode res = getKthFromEnd(p.next, 2);
        SingleLinkedList.print(res);
    }
}
