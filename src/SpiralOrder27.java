import java.util.Arrays;

/**
 * 顺时针打印矩阵
 * @author Lucas
 * @date 2021/02/10 10:09
 */
public class SpiralOrder27 {

    public static int[] spiralOrder(int[][] matrix) {
        // 如果二维数组为空 直接返回一个空数组
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        // 四边界分别代表左右上下、x一维数组索引
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            // 从左到右
            for(int i = l; i <= r; i++){
                res[x++] = matrix[t][i];
            }
            // 判断top往下走如果大于bottom了证明matrix已经遍历完了
            if(++t > b){
                break;
            }
            // 从上到下
            for(int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if(l > --r) {
                break;
            }
            // 从右到左
            for(int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if(t > --b) {
                break;
            }
            // 从下到上
            for(int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if(++l > r) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }
}
