import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * @author Lucas
 * @date 2021/03/08 14:55
 */
public class MaxSlidingWindow64 {

    /*public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k]){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }*/

    public int[] maxSlidingWindow(int[] nums, int k) {
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
    }

    public static void main(String[] args) {
        MaxSlidingWindow64 obj = new MaxSlidingWindow64();
        System.out.println(Arrays.toString(obj.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
