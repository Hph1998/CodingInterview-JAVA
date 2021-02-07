/**
 * 替换空格
 * @author Lucas
 * @date 2021/01/26 23:17
 */
public class ReplaceSpace03 {

    public static String replaceSpace(String s) {
        //单线程就不用考虑线程安全 当然选择性能更高的StringBuilder
        StringBuilder res = new StringBuilder();
        StringBuilder stringBuffer = new StringBuilder(s);
        for (int i = 0; i < stringBuffer.length(); i++){
            //截取当前位置的字符
            String temp = stringBuffer.substring(i,i+1);
            if (" ".equals(temp)){ //与空格相等则追加%20
                res.append("%20");
            }else { //否则直接追加当前字符
                res.append(temp);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

}
