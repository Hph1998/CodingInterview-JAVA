/**
 * 数字序列中某一位的数字
 * @author Lucas
 * @date 2021/02/24 10:38
 */
public class FindNthDigit44 {

    public int findNthDigit(int n) {
        // 表示几位数
        int digit = 1;
        // 几位数开始的数字
        long start = 1;
        // 几位数一共有多少个
        long count = 9;
        // 确定所在数字的是多少位的
        while (n > count) {
            n -= count;
            digit += 1;
            // 总结出来的规律
            start *= 10;
            count = digit * start * 9;
        }
        // 确定所在数字
        long num = start + (n - 1) / digit;
        // 确定所在数字的哪一位 -'0'转为整形
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        FindNthDigit44 findNthDigit44 = new FindNthDigit44();
        System.out.println(findNthDigit44.findNthDigit(100));
    }
}
