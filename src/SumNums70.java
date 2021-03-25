/**
 * 求1+2+…+n
 * @author Lucas
 * @date 2021/03/25 12:53
 */
public class SumNums70 {

    int res = 0;
    public int sumNums(int n) {
        // 当 n = 1 时 n > 1 不成立 ，此时短路，终止后续递归
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        SumNums70 obj = new SumNums70();
        System.out.println(obj.sumNums(3));
    }
}
