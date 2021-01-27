import java.util.Arrays;

/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName ReversePrint04.java
 * @Description 从尾到头打印链表
 * @createTime 2021年01月27日 09:38:00
 */
public class ReversePrint04 {



    public static int[] reversePrint(ListNode head){
        int len = 0;
        //用hold保留头结点
        ListNode hold = head;
        //计算链表长度
        while (head != null){
            len++;
            head = head.next;
        }
        int[] res = new int[len];
        //数组倒序存储链表正序
        for (int i = len - 1; i >= 0; i--){
            res[i] = hold.val;
            hold = hold.next;
        }
        return res;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint(head)));

    }

}
