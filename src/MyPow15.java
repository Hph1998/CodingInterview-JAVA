/**
 * 数值的整数次方
 * @author Lucas
 * @date 2021/02/03 13:54
 */
public class MyPow15 {

    public static double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        // 当n = -2147483648时执行
        // n = -n会因越界而赋值出错
        // 解决方法是先将n存入long变量l 后面用l操作即可
        long l = n;
        double res = 1;
        // 指数是负数 则把x置为倒数 指数变为正数用于循环
        if(l < 0) {
            x = 1 / x;
            l = -l;
        }
        // 当n为偶数：x^n = (x^2)^{n//2}
        // 当n为奇数：x^n = x(x^2)^{n//2}
        while(l != 0) {
            if((l & 1) == 1){
                res *= x;
            }
            x *= x;
            l >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
}
