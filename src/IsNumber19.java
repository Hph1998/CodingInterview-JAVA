/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName IsNumber19.java
 * @Description 表示数值的字符串
 * @createTime 2021年02月04日 17:35:00
 */
public class IsNumber19 {

    public static boolean isNumber(String s) {
        s = s.trim();
        try {
            Double.parseDouble(s);
        }catch (NumberFormatException e){
            return false;
        }
        // 排除特殊情况
        char last = s.charAt(s.length()-1);
        return (last >= '0' && last <= '9') || last == '.';
    }

    public static void main(String[] args) {
        System.out.println(isNumber(".1"));
    }
}
