/**
 * 二叉树的镜像
 * @author Lucas
 * @date 2021/02/09 10:56
 */
public class MirrorTree25 {

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        // 就像数组中两个数交换位置 用t变量暂时保存一个值 然后交换位置
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        // 递归实现子问题 左右子树也看做根节点
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.levelCreateTree(new int[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode res = mirrorTree(root);
        binaryTree.levelOrderTraverse(res);

    }
}
