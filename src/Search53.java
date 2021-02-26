/**
 * 在排序数组中查找数字 I 
 * @author Lucas
 * @date 2021/02/26 15:47
 */
public class Search53 {

    public int search(int[] nums, int target) {
        // 找target的右边界 - target-1的右边界
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0;
        int j = nums.length - 1;
        // 二分法查找
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Search53 search53 = new Search53();
        System.out.println(search53.search(new int[]{5, 7, 7, 8, 8, 10}, 9));
    }
}
