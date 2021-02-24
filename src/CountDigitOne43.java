/**
 * 1～n 整数中 1 出现的次数
 * @author Lucas
 * @date 2021/02/24 10:00
 */
public class CountDigitOne43 {

    public int countDigitOne(int n) {
        int res = 0;
        // 标记当前位数 个位为1 十位为10 百位为100 。。。。
        int digit = 1;
        // 初始化
        // 当前位置前面的数字
        int high = n / 10;
        // 当前位置的数字
        int cur = n % 10;
        // 当前位置后面的数字
        int low = 0;
        while (high != 0 || cur != 0){
            // 找规律 cur从0到9 会出现1的公式
            if (cur == 0){
                res += high * digit;
            }else if (cur == 1){
                res += high * digit + low + 1;
            }else {
                res += (high + 1) * digit;
            }
            // 重新赋值进行下一轮循环 找下一位会出现1的次数
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        CountDigitOne43 obj = new CountDigitOne43();
        System.out.println(obj.countDigitOne(12));
    }

}
