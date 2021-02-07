/**
 * 青蛙跳台阶问题
 * @author Lucas
 * @date 2021/01/30 14:42
 */
public class NumWays08 {

    /**
     * 其实就是斐波拉契数列的思路
     * 走一台阶一种方式
     * 走两台阶两种方式
     * 走三台阶即可拆分为走一台阶+走两台阶
     * @author Lucas
     * @date 2021/02/07 22:38
     * @param n 台阶数
     * @return int
     */
    public static int numWays(int n) {
        int a = 1;
        int b = 1;
        int sum = a + b;
        for(int i = 0; i < n; i++){
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        //返回a 可以排除n=0的特殊情况
        return a;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
