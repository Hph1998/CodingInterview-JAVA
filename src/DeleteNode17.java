/**
 * 删除链表的节点
 * @author Lucas
 * @date 2021/02/04 10:52:00
 */
public class DeleteNode17 {

    public static ListNode deleteNode(ListNode head, int val) {
        //保留头节点
        ListNode p = head;
        // 如果第一个就匹配 直接返回head的下一个节点
        if (p.val == val){
            return head.next;
        }
        // 循环判断
        while (p.next != null){
            if (p.next.val == val){
                // d保留要删除的节点
                ListNode d = p.next;
                // 当前节点指向当前的下下个节点
                p.next = p.next.next;
                // 把要删除的节点next置为空
                d.next = null;
                return head;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,5,1,9};
        //head是伪结点
        ListNode head = new ListNode(-1);
        SingleLinkedList.createTail(array, head);
        head = deleteNode(head.next, 5);
        SingleLinkedList.print(head);
    }
}
