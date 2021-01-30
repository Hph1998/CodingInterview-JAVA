/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName NumWays08.java
 * @Description 青蛙跳台阶问题
 * @createTime 2021年01月30日 14:42:00
 */
public class NumWays08 {

    /**其实就是斐波拉契数列的思路
     * 走一台阶一种方式
     * 走两台阶两种方式
     * 走三台阶即可拆分为走一台阶+走两台阶*/
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
