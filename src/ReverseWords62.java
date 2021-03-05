/**
 * 翻转单词顺序
 * @author Lucas
 * @date 2021/03/05 13:13
 */
public class ReverseWords62 {

    public String reverseWords(String s) {
        // 不考虑线程安全 StringBuilder性能更好
        StringBuilder stringBuilder = new StringBuilder();
        // 并且空格分割成数组
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; i >= 0; i--){
            // 遇到连续空格 直接进入下一轮
            if(strings[i].equals("")) {
                continue;
            }
            // 正常单词加进来并且追加空格
            stringBuilder.append(strings[i]).append(" ");
        }
        // 去掉最后一个空格
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords62 obj = new ReverseWords62();
        System.out.println(obj.reverseWords("  hello world!  "));
    }
}
