import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName CuttingRope12.java
 * @Description 剪绳子
 * @createTime 2021年02月02日 20:48:00
 */
public class CuttingRope12 {

    /**
     * @author: Lucas
     * @createTime: 2021/2/2 21:23
     * @Description: 这题就很脑筋急转弯 就是均分的情况下乘积最大
     * @param: [n]
     * @retrun: int
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
