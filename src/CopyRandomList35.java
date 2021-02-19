import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * @author Lucas
 * @date 2021/02/19 10:35
 */
public class CopyRandomList35 {

    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 复制各节点
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新链表的头节点
        return map.get(head);
    }



}
