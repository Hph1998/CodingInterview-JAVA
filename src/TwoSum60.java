import java.util.Arrays;

public class TwoSum60 {

    public int[] twoSum(int[] nums, int target) {
        // 双指针
        int i = 0;
        int j = nums.length - 1;
        // i，j相遇是出口
        while(i < j) {
            int sum = nums[i] + nums[j];
            // 递增序列 和小i++
            if(sum < target) {
                i++;
                // 和大j--
            } else if(sum > target) {
                j--;
            } else{
                // 找到一组满足 直接return
                return new int[] { nums[i], nums[j] };
            }
        }
        // i,j相遇还没有 那就是没有了
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum60 obj = new TwoSum60();
        System.out.println(Arrays.toString(obj.twoSum(new int[]{2, 3, 4, 15, 16, 19}, 19)));
    }
}
