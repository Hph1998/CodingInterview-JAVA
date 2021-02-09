import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * 对称的二叉树
 * @author Lucas
 * @date 2021/02/09 16:52
 */
public class IsSymmetric26 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        // 子问题判断每对节点是否对称
        return symmetric(root.left, root.right);
    }

    public static boolean symmetric(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        // 出口 有且只有一方为空或两值不相等
        if (left == null || right == null || left.val != right.val){
            return false;
        }
        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.levelCreateTree(new int[]{1,2,2,5,4,4,3});
        System.out.println(isSymmetric(root));
    }
}
