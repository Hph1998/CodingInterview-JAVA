import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @author Lucas
 * @date 2021/02/05 16:21
 */
public class Exchange20 {

    public static int[] exchange(int[] nums) {
        // 双指针
        int p1 = 0;
        int p2 = nums.length - 1;
        // 结束条件 两个指针碰头了
        while (p1 <= p2){
            // 前面遇到偶数了
            if (nums[p1] % 2 == 0){
                // 而且后面遇到奇数了
                if (nums[p2] % 2 != 0){
                    // 交换位置 前指针后移 后指针前移
                    int temp = nums[p1];
                    nums[p1] = nums [p2];
                    nums[p2] = temp;
                    p1++;
                }
                // 后面没遇到奇数 后指针一直前移
                p2--;
            }else {
                // 前面没遇到偶数 前指针一直后移
                p1++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {2,1,3,4,6};
        System.out.println(Arrays.toString(exchange(array)));
    }
}
