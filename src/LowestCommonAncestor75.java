/**
 * 二叉树的最近公共祖先
 * @author Lucas
 * @date 2021/04/25 11:07
 */
public class LowestCommonAncestor75 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // root为空就直接返回空 p和q中有等于root的最近公共祖先即为root
        if(root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 递归遍历左子树 在左子树中找到了p或q 先找到谁就返回谁
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归遍历右子树 在右子树中找到了p或q 先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 在左子树中p和q都找不到 则p和q一定都在右子树中
        if(left == null) {
            return right;
        }
        // 在右子树中p和q都找不到 则p和q一定都在左子树中
        if(right == null) {
            return left;
        }
        // 左右都不为空 说明p、q节点分别在root异侧 最近公共祖先即为root
        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.levelCreateTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        LowestCommonAncestor75 obj = new LowestCommonAncestor75();
        System.out.println(obj.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(4)).val);
    }
}
