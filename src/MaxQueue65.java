import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 * @author Lucas
 * @date 2021/03/10 11:31
 */
public class MaxQueue65 {

    // 存储队列
    Queue<Integer> queue;
    // 单调双向队列
    Deque<Integer> deque;

    public MaxQueue65() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        // 空返回-1 非空返回队头
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        // 一直循环删除到队列中的值都大于当前值，或者删到队列为空
        while(!deque.isEmpty() && deque.peekLast() < value){
            // 队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            deque.removeLast();
        }
        // 执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
        deque.offerLast(value);
    }

    public int pop_front() {
        // 空返回-1
        if (queue.isEmpty()){
            return -1;
        }
        // 如果数据队列和单调双向队列队头相等
        if (queue.peek().equals(deque.peekFirst())){
            // 单调双向队列也要出栈以保持两队列元素一致
            deque.removeFirst();
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        MaxQueue65 obj = new MaxQueue65();
        obj.push_back(1);
        obj.push_back(2);
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
    }

}
