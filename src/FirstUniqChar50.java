import java.util.HashMap;

/**
 * 第一个只出现一次的字符
 * @author Lucas
 * @date 2021/02/25 17:20
 */
public class FirstUniqChar50 {

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        // 循环存入map
        for(char c : sc) {
            // 第一次插入全为true 只有有重复key就覆盖成false
            dic.put(c, !dic.containsKey(c));
        }
        // 循环查找第一个只有一个的数
        for(char c : sc) {
            if(dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    /*public char firstUniqChar(String s) {
        // 遍历
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // 某个字符出现的位置就是当前i的位置 且 i之前没有出现过这个字符
            if (i == s.lastIndexOf(ch) && !s.substring(0, i).contains(String.valueOf(ch))){
                return ch;
            }
        }
        return ' ';
    }*/

    public static void main(String[] args) {
        FirstUniqChar50 obj = new FirstUniqChar50();
        System.out.println(obj.firstUniqChar("abaccdeffa"));
    }
}
