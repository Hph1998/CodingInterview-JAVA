import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 * @author Lucas
 * @date 2021/02/23 09:42
 */
public class MedianFinder41 {

    PriorityQueue<Integer> A, B;
    public MedianFinder41() {
        //规定 小顶堆 保存较大的一半 长度为N/2 或 (N+1)/2
        A = new PriorityQueue<>();
        //规定 大顶堆 保存较小的一半 长度为N/2 或 (N-1)/2
        B = new PriorityQueue<>((x, y) -> (y - x));
    }
    public void addNum(int num) {
        //保持平衡 AB不能相差超过1
        if(A.size() != B.size()) {
            // 条件成立 证明当前是奇数 再插入则为偶数了
            // 为了平衡 A先进队 记住是有序的
            A.add(num);
            // B进队 A出队 进出的是A里最小的 就平衡了
            B.add(A.poll());
        } else {
            // 不成立 即为当前偶数 在插入即为奇数
            // 按照规则 这时候应该A比B多1 同理
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        // 条件成立 证明是奇数 从小顶堆取值
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }



}
