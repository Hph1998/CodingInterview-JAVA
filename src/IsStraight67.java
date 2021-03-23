import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 * @author Lucas
 * @date 2021/03/23 16:07
 */
public class IsStraight67 {

    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            // 跳过大小王 不用考虑有几个大小王 因为不重复且最大-最小<5是形成顺子必然事件
            if(num == 0) {
                continue;
            }
            // 最大牌
            max = Math.max(max, num);
            // 最小牌
            min = Math.min(min, num);
            // 若有重复，提前返回 false
            if(repeat.contains(num)) {
                return false;
            }
            repeat.add(num); // 添加此牌至 Set
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return max - min < 5;
    }

    public static void main(String[] args) {
        IsStraight67 obj = new IsStraight67();
        System.out.println(obj.isStraight(new int[]{1, 2, 3, 4, 5}));
    }
}
