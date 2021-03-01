/**
 * 0～n-1中缺失的数字
 * @author Lucas
 * @date 2021/03/01 09:35
 */
public class MissingNumber54 {

    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            // 二分查找
            int m = (i + j) / 2;
            // 如果相等 证明前面没有缺失 则取 m + 1 ~ j
            if(nums[m] == m) {
                i = m + 1;
                // 否则 前面缺失 则取 0 ~ m - 1
            } else {
                j = m - 1;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        MissingNumber54 obj = new MissingNumber54();
        System.out.println(obj.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }
}
