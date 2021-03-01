/**
 * 二叉树的深度
 * @author Lucas
 * @date 2021/03/01 10:21
 */
public class MaxDepth56 {

    public int maxDepth(TreeNode root) {
        // 后序遍历
        if (root == null){
            return 0;
        }
        // 此树的深度等于左子树的深度与右子树的深度中的最大值 +1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
