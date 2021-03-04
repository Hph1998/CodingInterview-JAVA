import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为s的连续正数序列
 * @author Lucas
 * @date 2021/03/04 13:03
 */
public class FindContinuousSequence61 {

    public int[][] findContinuousSequence(int target) {
        // 滑动窗口
        int i = 1;
        int j = 2;
        int sum = 3;
        List<int[]> res = new ArrayList<>();
        // i,j相遇即为出口
        while(i < j) {
            // 小于时 j往后走 并把j加上
            if(sum < target) {
                j++;
                sum += j;
            } else {
                // 等于时 存入数组从i-j
                if(sum == target) {
                    int[] ans = new int[j - i + 1];
                    for(int k = i; k <= j; k++) {
                        ans[k - i] = k;
                    }
                    res.add(ans);
                }
                // 大于等于时 先把i减掉 i往后走
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        FindContinuousSequence61 obj = new FindContinuousSequence61();
        System.out.println(Arrays.deepToString(obj.findContinuousSequence(1)));
    }
}
