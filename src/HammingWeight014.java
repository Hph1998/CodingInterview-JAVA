/**
 * 二进制中1的个数
 * @author Lucas
 * @date 2021/02/03 13:22
 */
public class HammingWeight014 {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            // 与运算
            // 若 n & 1 = 0，则 n 二进制 最右一位 为 0
            // 若 n & 1 = 1，则 n 二进制 最右一位 为 1
            count += n & 1;
            // 无符号右移 用 0 补充前面
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(9));
    }
}
