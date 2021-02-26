/**
 * 数组中的逆序对 
 * @author Lucas
 * @date 2021/02/26 13:34
 */
public class ReversePairs51 {

    public int reversePairs(int[] nums) {
        // 用于合并阶段存放数组
        int[] tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1, tmp, nums);
    }

    private int mergeSort(int l, int r, int[] tmp, int[] nums) {
        // 终止条件
        if (l >= r) {
            return 0;
        }
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m, tmp, nums) + mergeSort(m + 1, r, tmp, nums);
        // 合并阶段
        // 设置双指针 i , j 分别指向左 / 右子数组的首元素
        int i = l, j = m + 1;
        // 暂存数组 nums 闭区间 [i, r] 内的元素至辅助数组 tmp
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            // 代表左子数组已合并完，因此添加右子数组当前元素 tmp[j] ，并执行 j = j + 1
            if (i == m + 1) {
                nums[k] = tmp[j++];
                //代表右子数组已合并完，因此添加左子数组当前元素 tmp[i] ，并执行 i = i + 1 或 添加左子数组当前元素 tmp[i] 并执行 i = i + 1
            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
                // 添加右子数组当前元素 tmp[j] 并执行 j = j + 1 此时构成 m - i + 1 个逆序对
            } else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReversePairs51 obj = new ReversePairs51();
        System.out.println(obj.reversePairs(new int[]{7, 5, 6, 4}));
    }
}
