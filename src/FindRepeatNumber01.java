import java.util.HashMap;

/**
 * 数组中重复的数字
 * @author Lucas
 * @date 2021/01/26 21:41
 */
public class FindRepeatNumber01 {

    /*public static int findRepeatNumber(int[] nums) {

        //由于HashMap的key不重复
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int temp : nums) {
            if (map.containsKey(temp)) {//判断map是否包含这个值 直接返回
                return temp;
            }
            map.put(temp, 0);//不存在 这存入map
        }
        return -1;
    }*/

    /**
     * 优化答案
     * @author Lucas
     * @date 2021/02/07 22:46
     * @param nums 数组
     * @return int
     */
    public static int findRepeatNumber(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            while(i != nums[i]) { //出口 下标与值相等
                if(nums[nums[i]] == nums[i]) { //下标位置已经存在正确的值了 说明重复了
                    return nums[i];
                }
                swap(nums, i, nums[i]); //把当前值与相等下标的值互换
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {

        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));

    }

}
