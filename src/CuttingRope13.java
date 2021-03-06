import java.math.BigInteger;

/**
 * 剪绳子
 * @author Lucas
 * @date 2021/02/02 21:56:00
 */
public class CuttingRope13  {


    /*public static int cuttingRope(int n) {
        BigInteger max = BigInteger.valueOf(0);
        for (int i = 2; i<= n; i++){
            //这题就很脑筋急转弯 就是均分的情况下乘积最大
            max = max.max(cutting(n, i));
        }
        return max.remainder(BigInteger.valueOf(1000000007)).intValue();
    }

    public static BigInteger cutting(int n, int m){
        // 每段的长度 只能是整数
        BigInteger length = BigInteger.valueOf(n / m);
        // 剩余的长度
        int reduce = n % m;
        // 因为存在剩余长度且不大于m 根据平均分乘积最大的原理 有reduce根绳子+1做到最平均 得到下面的式子
        return length.pow(m - reduce).multiply(length.add(BigInteger.valueOf(1)).pow(reduce));
    }*/

    /**
     * 这个据数学证明：当n>=3时因数拆分成3的计算结果较大、当n<3时因数越大，结果越大
     * @author Lucas
     * @date 2021/02/07 22:51
     * @param n 段数
     * @return int
     */
    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n-1;
        }
        long res = 1;
        while(n > 4){
            res = res *3 % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(1000));
    }
}
