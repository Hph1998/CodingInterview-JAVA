import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * @author Lucas
 * @date 2021/03/08 14:55
 */
public class MaxSlidingWindow64 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        // 单调队列
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            // 一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                // 队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
                deque.removeLast();
            }
            // 执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        // 队头就是第一个窗口的最大值
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            // i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if(deque.peekFirst() == nums[i - k]){
                deque.removeFirst();
            }
            // 删除队列中比当前值大的值
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            // 把当前值添加到队列中
            deque.addLast(nums[i]);
            // 把队列的首位值添加到arr数组中
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    /*public int[] maxSlidingWindow(int[] nums, int k) {
        // 数组为空 直接返回空数组
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        // 返回的结果
        int res[] = new int[nums.length - k + 1];
        // 左边界
        int j = 0;
        // k为右边界 超出nums.length为出口
        while (k <= nums.length){
            // 复制左右区间内的数组
            int now[] = Arrays.copyOfRange(nums, j, k);
            int temp = now[0];
            // 循环找到最大值
            for (int i = 1; i < now.length; i++){
                temp = Math.max(temp, now[i]);
            }
            // 最大值加入结果集
            res[j++] = temp;
            k = k + 1;
        }
        return res;
    }*/

    public static void main(String[] args) {
        MaxSlidingWindow64 obj = new MaxSlidingWindow64();
        System.out.println(Arrays.toString(obj.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
