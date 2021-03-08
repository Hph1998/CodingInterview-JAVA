/**
 * 左旋转字符串
 * @author Lucas
 * @date 2021/03/08 14:43
 */
public class ReverseLeftWords63 {

    public String reverseLeftWords(String s, int n) {
        // 重新拼接字符串 n - s.length() 加上 0 - n
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        ReverseLeftWords63 obj = new ReverseLeftWords63();
        System.out.println(obj.reverseLeftWords("abcdefg", 2));
    }
}
