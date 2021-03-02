import java.util.Arrays;
import java.util.HashMap;

/**
 * 数组中数字出现的次数 II
 * @author Lucas
 * @date 2021/03/02 14:46
 */
public class SingleNumber59 {

    /*public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        // 遍历将出现一次的数字value置为true，出现多次的value置为false
        for (int num : nums){
            if (hashMap.get(num) == null){
                hashMap.put(num, true);
            }else {
                hashMap.put(num, false);
            }
        }
        int res = -1;
        // 找到value为true的数字
        for(int key: hashMap.keySet()){
            if (hashMap.get(key)){
                res = key;
                break;
            }
        }
        return res;
    }*/
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        SingleNumber59 obj = new SingleNumber59();
        System.out.println(obj.singleNumber(new int[]{9,1,7,9,7,9,7}));
    }
}
