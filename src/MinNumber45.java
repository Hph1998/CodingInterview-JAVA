import java.util.Arrays;

/**
 * 把数组排成最小的数
 * @author Lucas
 * @date 2021/02/24 11:14
 */
public class MinNumber45 {

    public String minNumber(int[] nums) {
        // 想到排序的时候对字符串排序是根据首位ASCII码 符合题目意愿
        String[] array = new String[nums.length];
        // 转成String数组
        for (int i = 0; i < nums.length ; i++){
            array[i] = Integer.toString(nums[i]);
        }
        // Lambda表达式重写排序规则
        Arrays.sort(array, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder s = new StringBuilder();
        // 排序后拼接结果
        for (String num : array){
            s.append(num);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        MinNumber45 obj = new MinNumber45();
        System.out.println(obj.minNumber(new int[]{3,30,34,5,9}));
    }
}
