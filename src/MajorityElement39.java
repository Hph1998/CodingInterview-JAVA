import sun.security.util.Length;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 数组中出现次数超过一半的数字
 * @author Lucas
 * @date 2021/02/22 10:38
 */
public class MajorityElement39 {

    /*public static int majorityElement(int[] nums) {
        // HashMap nums作为key 出现次数作为value
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // res保存key
        int res = 0;
        // max保存出现最多次数的value
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            Integer value = hashMap.get(nums[i]);
            // 如果map中还不存在 避免异常 赋值为0
            if (value == null){
                value = 0;
            }
            // 存在的话value+1 覆盖key
            hashMap.put(nums[i], ++value);
            if (value > max){
                max = value;
                res = nums[i];
            }
        }
        return res;
    }*/

    /*public static int majorityElement(int[] nums) {
        // 利用条件数组中有一个数字出现的次数超过数组长度的一半
        // 那么排序以后中间的数字就是我们要的
        // 太妙了 很特殊
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }*/

    public static int majorityElement(int[] nums) {
        // 摩尔投票法
        int x = 0;
        int votes = 0;
        for(int num : nums){
            // 票数为0 则假设当前值为众数
            if(votes == 0) {
                x = num;
            }
            // 当前值和众数一样则票数加1 否则减1
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
