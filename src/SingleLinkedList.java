/**
 * 单链表及操作
 * @author Lucas
 * @date 2021/01/27/ 10:12
 */
public class SingleLinkedList {

    /**
     * 头插法
     * @author Lucas
     * @date 2021/02/07 22:33
     * @param array 链表数据
     * @param head 头节点
     * @return ListNode
     */
    public static ListNode createHead(int[] array, ListNode head){
        for (int value : array) {
            ListNode p = new ListNode(value);
            p.next = head.next;
            head.next = p;
        }
        return head.next;
    }

    /**
     * 尾插法
     * @author Lucas
     * @date 2021/02/07 22:34
     * @param array 链表数据
     * @param head 头节点
     * @return ListNode
     */
    public static ListNode createTail(int[] array, ListNode head){
        ListNode t,p;
        t = head;
        for (int value : array){
            p = new ListNode(value);
            t.next = p;
            //使t始终指向最后一个元素
            t = p;
        }
        return head.next;
    }

    /**
     * 链表长度
     * @author Lucas
     * @date 2021/02/07 22:35
     * @param head 头节点
     * @return int
     */
    public static int size(ListNode head){
        int res = 0;
        if(head == null){
            return res;
        }
        ListNode p = head.next;
        while(p != null){
            res++;
            p = p.next;
        }
        return res;
    }

    /**
     * 输出链表
     * @author Lucas
     * @date 2021/02/07 22:35
     * @param head 头节点
     * @return void
     */
    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val);
            head = head.next;
            if (head == null) {
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        //head是伪结点
        ListNode head = new ListNode(-1);
        createTail(array,head);
        System.out.println(size(head));
    }

}
