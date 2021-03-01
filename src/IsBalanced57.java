/**
 * 平衡二叉树
 * @author Lucas
 * @date 2021/03/01 11:53
 */
public class IsBalanced57 {

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root) {
        // 后续遍历
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if(left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if(right == -1) {
            return -1;
        }
        // 左右子树深度小于2 则返回深度 否则 返回-1判定不是平衡
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
