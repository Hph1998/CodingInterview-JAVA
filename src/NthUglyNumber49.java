import java.util.Arrays;

/**
 * 丑数
 * @author Lucas
 * @date 2021/02/25 16:31
 */
public class NthUglyNumber49 {

    /**
     * 动态规划
     * 有规律后面的丑数都是由前面的丑数*2或*3或*5得来的
     * 求得的丑数记录dp数组中
     * 三个指针p2,p3,p5
     * p2指向的数字下一次永远*2，p3指向的数字下一次永远*3，p5指向的数字永远*5
     * 从2*p2 3*p3 5*p5取最小的数，作为第k个丑数
     * 返回第n个丑数
     */
    public int nthUglyNumber(int n) {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if(dp[i] == dp[p2] * 2) {
                p2++;
            }
            if(dp[i] == dp[p3] * 3) {
                p3++;
            }
            if(dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        NthUglyNumber49 obj = new NthUglyNumber49();
        System.out.println(obj.nthUglyNumber(10));
    }
}
