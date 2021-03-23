import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * @author Lucas
 * @date 2021/03/23 16:33
 */
public class LastRemaining68 {

    /*public int lastRemaining(int n, int m) {
        // 把这个0 ~ n-1存起来
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(i);
        }
        int delete = 0;
        // 循环直到list中只剩一个
        while (list.size() > 1){
            // 得到删除的下标并删除
            delete = (delete + m - 1) % list.size();
            list.remove(delete);
        }
        return list.get(0);
    }*/

    public int lastRemaining(int n, int m) {
        int x = 0;
        // 最后一轮剩下2个，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

    public static void main(String[] args) {
        LastRemaining68 obj = new LastRemaining68();
        System.out.println(obj.lastRemaining(10, 17));
    }
}
