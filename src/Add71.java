/**
 * 不用加减乘除做加法
 * @author Lucas
 * @date 2021/03/25 13:12
 */
public class Add71 {

    public int add(int a, int b) {
        // 当进位为 0 时跳出
        while(b != 0) {
            // c = 进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        Add71 obj = new Add71();
        System.out.println(obj.add(1, 1));
    }
}
