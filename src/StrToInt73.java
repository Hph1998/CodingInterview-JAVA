/**
 * 把字符串转换成整数
 * @author Lucas
 * @date 2021/04/25 09:58
 */
public class StrToInt73 {

    public int strToInt(String str) {
        // 删除头尾空白符
        char[] nums = str.trim().toCharArray();
        if(nums.length == 0) {
            return 0;
        }
        int res = 0;
        // 边界值 两种越界情况 res > bndry 和 res = bndry 且 x > 7
        int bndry = Integer.MAX_VALUE / 10;
        int i = 1;
        // 正负数
        int sign = 1;
        if(nums[0] == '-') {
            sign = -1;
        }
        else if(nums[0] != '+') {
            // 无符号 则要从第一个位置开始拼接
            i = 0;
        }
        for(int j = i; j < nums.length; j++) {
            // 不是数字直接跳出循环
            if(nums[j] < '0' || nums[j] > '9') {
                break;
            }
            // 越界
            if(res > bndry || res == bndry && nums[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 字符转数字
            res = res * 10 + (nums[j] - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {

        StrToInt73 strToInt73 = new StrToInt73();
        System.out.println(strToInt73.strToInt("    -4a3  adsa"));
    }
}
