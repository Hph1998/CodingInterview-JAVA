import java.util.Arrays;

public class DicesProbability66 {

    public double[] dicesProbability(int n) {
        // 初始化一个筛子
        double[] dp = new double[6];
        // 初始化数组全是六分之一
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            // 创建临时结果集
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    // 递推公式
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            // 保存结果
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        DicesProbability66 obj = new DicesProbability66();
        obj.dicesProbability(6);
    }
}
