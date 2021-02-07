/**
 * 矩阵中的路径
 * @author Lucas
 * @date 2021/01/31 12:18
 */
public class Exist10 {

    /**
     * 典型的回溯
     * @author Lucas
     * @date 2021/02/07 22:49
     * @param board 二维数组字典
     * @param word 单词
     * @return boolean
     */
    public static boolean exist(char[][] board, String word) {

        int h = board.length;
        int w = board[0].length;
        //经过矩阵的某个格子不允许被重复使用，visited用于标记是否已经经过
        boolean[][] visited = new boolean[h][w];
        //因为每一个格子都可以作为起始点，所以两次循环不可避免了
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                //解释一下index用户标记当前匹配到word中的第几个字符
                boolean res = search(board, word, i, j, 0, visited);
                if (res){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean search(char[][] board, String word, int i, int j, int index, boolean[][] visited){
        //word已经全部匹配成功
        if (index >= word.length()){
            return true;
        }
        //i j越界、已经访问过了、word当前字符与board中的不匹配
        if (i < 0 || j < 0 || i >= board.length || j>= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        //经过了的记为true
        visited[i][j] = true;
        //上下左右四个方向 只要有一个方向匹配即可
        boolean res = search(board, word , i + 1, j, index + 1, visited) || search(board, word , i - 1, j, index + 1, visited) || search(board, word , i, j + 1, index + 1, visited) || search(board, word , i, j - 1, index + 1, visited);
        //进入到下一个循环前，重置visited为false
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "bfca";
        System.out.println(exist(board, word));
    }
}
