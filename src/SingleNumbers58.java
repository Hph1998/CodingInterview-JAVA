import java.util.Arrays;

/**
 * 数组中数字出现的次数
 * @author Lucas
 * @date 2021/03/02 14:02
 */
public class SingleNumbers58 {

    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        // 遍历异或
        for(int num : nums) {
            n ^= num;
        }
        // 循环左移，计算 m
        while((n & m) == 0) {
            m <<= 1;
        }
        // 遍历 nums 分组
        for(int num: nums) {
            if((num & m) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[] {x, y};
    }

    public static void main(String[] args) {
        SingleNumbers58 obj = new SingleNumbers58();
        System.out.println(Arrays.toString(obj.singleNumbers(new int[]{4, 2, 4, 6})));
    }
}
