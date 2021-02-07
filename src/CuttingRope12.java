import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * 剪绳子
 * @author Lucas
 * @date 2021/02/02 20:48
 */
public class CuttingRope12 {

    /**
     * 这题就很脑筋急转弯 就是均分的情况下乘积最大
     * @author Lucas
     * @date 2021/02/07 22:53
     * @param n 段数
     * @return int
     */
    public static int cuttingRope(int n) {
        int max = 0;
        for (int i = 2; i<= n; i++){
            max = Math.max(cutting(n, i), max);
        }
        return max;
    }

    public static int cutting(int n, int m){
        // 每段的长度 只能是整数
        int length = n / m;
        // 剩余的长度
        int reduce = n % m;
        // 因为存在剩余长度且不大于m 根据平均分乘积最大的原理 有reduce根绳子+1做到最平均 得到下面的式子
        return (int) (Math.pow(length, m - reduce) * Math.pow(length + 1, reduce));
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }

}
