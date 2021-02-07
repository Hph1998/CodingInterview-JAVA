import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 * @author Lucas
 * @date 2021/02/04 10:30
 */
public class PrintNumbers16 {

    public static int[] printNumbers(int n) {
        // 规律 计算出数组的长度
        int count = (int) Math.pow(10,n) - 1;
        int[] res = new int[count];
        // 只能是循环插入数据了
        for (int i = 0; i < count; i++){
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(3)));
    }
}
