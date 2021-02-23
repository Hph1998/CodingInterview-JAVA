/**
 * 连续子数组的最大和
 * @author Lucas
 * @date 2021/02/23 11:44
 */
public class MaxSubArray42 {

    public int maxSubArray(int[] nums) {
        // 动态规划法
        // 因为不需要输出具体是哪一段得出的最大和 直接在原数组上操作
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            // 以元素 nums[i] 为结尾的连续子数组最大和
            // 如果它前面是个负数就不要加进来拖后腿了 加个0 最大和就是它本身
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSubArray42 obj = new MaxSubArray42();
        System.out.println(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
