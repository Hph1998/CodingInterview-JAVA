import java.util.Arrays;

/**
 * 最小的k个数
 * @author Lucas
 * @date 2021/02/22 11:46
 */
public class GetLeastNumbers40 {

    /*public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }*/

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    public void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) {
            return;
        }
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        GetLeastNumbers40 getLeastNumbers40 = new GetLeastNumbers40();
        System.out.println(Arrays.toString(getLeastNumbers40.getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }
}
