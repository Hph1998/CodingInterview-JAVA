/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName LinkedList.java
 * @Description 顺带复习单链表
 * @createTime 2021年01月27日 10:12:00
 */
public class SingleLinkedList {

    /**
     * @author: Lucas
     * @createTime: 2021/1/27 11:12
     * @Description 头插法建表
     * @param: [array, head]
     * @retrun: ListNode
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
     * @author: Lucas
     * @createTime: 2021/1/27 14:39
     * @Description 尾插法建表
     * @param: [array, head]
     * @retrun: ListNode
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
     * @author: Lucas
     * @createTime: 2021/1/27 15:15
     * @Description 单链表长度
     * @param: [head]
     * @retrun: int
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
     * @author: Lucas
     * @createTime: 2021/2/4 11:11
     * @Description 打印链表
     * @param: [head]
     * @retrun: void
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
