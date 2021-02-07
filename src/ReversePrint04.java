import java.util.Arrays;

/**
 * 从尾到头打印链表
 * @author Lucas
 * @date 2021/01/27 09:38
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
