/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName Fib07.java
 * @Description 斐波那契数列
 * @createTime 2021年01月30日 14:06:00
 */
public class Fib07 {

    //无脑递归 超出时间限制 哈哈哈哈哈哈
    /*public static int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return (fib(n-1) + fib(n-2)) % 1000000007;
    }*/

    public static int fib(int n) {
        if (n < 2){
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = a + b;
        //a b sum 每次循环用前两个变量保留b和sum
        for(int i = 2; i < n ; i++){
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(fib(5));

    }

}
