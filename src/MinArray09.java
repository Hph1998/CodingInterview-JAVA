import java.util.Arrays;

/**
 * 旋转数组的最小数字
 * @author Lucas
 * @date 2021/01/31 11:42
 */
public class MinArray09 {

    /**
     * 啊这
     * 我干了啥
     * 按题目意思就是输出数组的最小值啊
     * @author Lucas
     * @date 2021/02/07 22:42
     * @param numbers 数组
     * @return int
     */
    /*public static int minArray(int[] numbers) {
        //排序就完事了
        Arrays.sort(numbers);
        return numbers[0];
    }*/
    public static int minArray(int[] numbers){
        //因为循环里有i+1 所以注意循环条件不能越界了
        for (int i = 0; i < numbers.length - 1; i++){
            //出现了当前值大于下一个值 那就是找到了最小值了
            if (numbers[i] > numbers[i + 1]){
                return numbers[i + 1];
            }
        }
        //不满足上面的出口 证明这个数组本身就是递增的
        return numbers[0];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3,4,5,1,2};
        System.out.println(minArray(numbers));
    }
}
