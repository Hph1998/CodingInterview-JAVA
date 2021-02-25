/**
 * 把数字翻译成字符串
 * @author Lucas
 * @date 2021/02/25 09:50
 */
public class TranslateNum46 {

    public int translateNum(int num) {
        // 动态规划法
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        // 初始化dp[0]代表空数字 dp[1]代表第一个数字 的组合翻译方式有一种
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++){
            String temp = s.substring(i - 2, i);
            // ASCII比较 满足10-25是字母所在的范围内
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        TranslateNum46 obj = new TranslateNum46();
        System.out.println(obj.translateNum(12258));
    }
}
