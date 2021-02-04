/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName IsMatch18.java
 * @Description 正则表达式匹配
 * @createTime 2021年02月04日 11:39:00
 */
public class IsMatch18 {

    /*public static boolean isMatch(String s, String p) {
        //如果模式串为空，则只能匹配空的匹配串。
        if (p.isEmpty()){
            return s.isEmpty();
        }
        //记录匹配串的第一个字符是否被模式串匹配。
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        //模式串包含两个字符及以上并且第二个字符为 * 。
        if (p.length() >= 2 && p.charAt(1) == '*'){
            //如果模式串第三个字符往后可以匹配原匹配串
            //或者匹配串删除第一个匹配的字符后可以被模式串匹配，则表示可匹配。
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            //如果模式串只有一个字符或者第二个字符不是* ，
            //则匹配串第一个字符被模式串匹配并且分别删除第一个字符后模式串还能匹配匹配串。
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }*/

    public static boolean isMatch(String s, String p){
        int n = s.length();
        int m = p.length();
        // 对于空串的处理方便 结果就是f[n][m]
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
