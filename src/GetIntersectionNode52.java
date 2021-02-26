/**
 * 两个链表的第一个公共节点
 * @author Lucas
 * @date 2021/02/26 14:45
 */
public class GetIntersectionNode52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 双指针 消除两个链表的长度差
        ListNode pA = headA;
        ListNode pB = headB;
        // 直到A、B相遇
        while (pA != pB){
            // A先自己遍历完
            // 然后A就变成了B 继续遍历
            if(pA == null){
                pA = headB;
            }else{
                pA = pA.next;
            }
            // B先自己遍历完
            // 然后B就变成了A 继续遍历
            if (pB == null){
                pB = headA;
            }else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
