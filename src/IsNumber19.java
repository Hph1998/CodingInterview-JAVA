import java.util.HashMap;
import java.util.Map;

/**
 * 表示数值的字符串
 * @author Lucas
 * @date 2021/02/04 17:35
 */
public class IsNumber19 {

    /*public static boolean isNumber(String s) {
        s = s.trim();
        try {
            Double.parseDouble(s);
        }catch (NumberFormatException e){
            return false;
        }
        // 排除特殊情况
        char last = s.charAt(s.length()-1);
        return (last >= '0' && last <= '9') || last == '.';
    }*/

    /*public static boolean isNumber(String s) {
        // 主要就是把有限状态自动机画出来
        Map[] states = {
                new HashMap<Character, Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }},
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 4); }},
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }},
                new HashMap<Character, Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},
                new HashMap<Character, Integer>() {{ put('d', 3); }},
                new HashMap<Character, Integer>() {{ put('s', 6); put('d', 7); }},
                new HashMap<Character, Integer>() {{ put('d', 7); }},
                new HashMap<Character, Integer>() {{ put('d', 7); put(' ', 8); }},
                new HashMap<Character, Integer>() {{ put(' ', 8); }}
        };
        // 标记当前状态
        int p = 0;
        // 用于数字、符号、幂符号转换
        char t;
        for (char c: s.toCharArray()){
            if (c >= '0' && c <= '9'){
                t = 'd';
            }else if (c == '+' || c == '-'){
                t = 's';
            }else if (c == 'e' || c == 'E'){
                t = 'e';
            }
            else if (c == '.' || c == ' '){
                t = c;
            }else {
                t = '?';
            }
            if (!states[p].containsKey(t)){
                return false;
            }
            p = (int) states[p].get(t);
        }
        // 合法的结束状态有 2, 3, 7, 8
        return p == 2 || p == 3 || p == 7 || p == 8;
    }*/

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        //去掉头尾空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }

    public static void main(String[] args) {
        System.out.println(isNumber(".1"));
    }
}
