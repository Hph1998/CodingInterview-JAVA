import java.util.Arrays;

/**
 * 构建乘积数组
 * @author Lucas
 * @date 2021/04/23 16:40
 */
public class ConstructArr72 {

    /**
     * 思路：看做一张表格，列和行为a、b两个数组，对角线上的数组看做1，将表格分为上下两个三角
     * @author Lucas
     * @date 2021/04/23 18:17
     * @param a
     * @return int[]
     */
    public int[] constructArr(int[] a) {
        int len = a.length;
        //长度为0 直接返回空数组
        if(len == 0){
            return new int[0];
        }
        int[] b = new int[len];
        // 初始化b[0] 避免任何数乘以0都是0
        b[0] = 1;
        // 计算上三角暂存temp 再跟b[i]相乘
        int temp = 1;
        //计算下三角
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //计算上三角
        for(int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }

    public static void main(String[] args) {
        ConstructArr72 obj = new ConstructArr72();
        System.out.println(Arrays.toString(obj.constructArr(new int[]{1, 2, 3, 4, 5})));
    }
}
