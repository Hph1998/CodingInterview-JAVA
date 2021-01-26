import java.util.HashMap;

/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName FindRepeatNumber01.java
 * @Description 数组中重复的数字
 * @createTime 2021年01月26日 21:41:00
 */
public class FindRepeatNumber01 {

    public static int findRepeatNumber(int[] nums) {

        //由于HashMap的key不重复
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int temp : nums) {
            if (map.containsKey(temp)) {//判断map是否包含这个值 直接返回
                return temp;
            }
            map.put(temp, 0);//不存在 这存入map
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));

    }

}
