/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName FindNumberIn2DArray02.java
 * @Description TODO
 * @createTime 2021年01月26日 15:55:00
 */
public class FindNumberIn2DArray02 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //判断二维数组没有值直接返回false
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int hLen = matrix.length;
        int wLen = matrix[0].length;
        for (int i = 0; i < hLen; i++){
            for (int j = 0;j< wLen; j++) {
                int key = matrix[i][j];
                if (key == target) {//已经找到数组中有target返回true
                    return true;
                } else if (key > target) { //由于递增当前行后面的数已经没有判断的意义 跳出当前循环
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int [][]array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(findNumberIn2DArray(array, 7));
    }

}
