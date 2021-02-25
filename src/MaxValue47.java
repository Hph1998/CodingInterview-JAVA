/**
 * 礼物的最大价值
 * @author Lucas
 * @date 2021/02/25 10:35
 */
public class MaxValue47 {

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 初始化矩阵第一行
        for(int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // 初始化矩阵第一列
        for(int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                // 加上之前的最大路径值
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MaxValue47 obj = new MaxValue47();
        System.out.println(obj.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
