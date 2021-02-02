/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName MovingCount11.java
 * @Description 机器人的运动范围
 * @createTime 2021年02月02日 12:52:00
 */
public class MovingCount11 {

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        // 机器人从[0,0]坐标开始移动
        return search(m, n, k, visited, 0, 0);
    }

    public static int search(int m, int n, int k, boolean[][] visited, int x, int y){
        // 递归终止条件：x y越界、已经访问过、不满足数位和小于等于k
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || compare(x, y, k)){
            return 0;
        }
        visited[x][y] = true;
        // 递归只需要考虑两个方向 向右或向下
        return 1 + search(m, n, k, visited, x + 1, y) + search(m, n, k, visited, x, y + 1);
    }

    /**
     * @author: Lucas
     * @createTime: 2021/2/2 14:10
     * @Description 行坐标和列坐标的数位之和与k比较
     * @param: [x, y, k]
     * @retrun: boolean
     */
    public static boolean compare(int x, int y, int k){
        int sumX = x / 100 + (x % 100) / 10 + x % 10;
        int sumY = y / 100 + (y % 100) / 10 + y % 10;
        if (sumX + sumY > k){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(movingCount(38, 15, 9));
    }
}
