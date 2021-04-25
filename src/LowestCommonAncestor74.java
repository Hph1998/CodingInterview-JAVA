/**
 * 二叉搜索树的最近公共祖先
 * @author Lucas
 * @date 2021/04/25 10:41
 */
public class LowestCommonAncestor74 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            // p,q 都在 root 的右子树中
            if(root.val < p.val && root.val < q.val) {
                // 遍历至右子节点
                root = root.right;
                // p,q 都在 root 的左子树中
            } else if(root.val > p.val && root.val > q.val) {
                // 遍历至左子节点
                root = root.left;
            } else {
                // p,q分列两侧 说明已经找到最近公共祖先
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.levelCreateTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        LowestCommonAncestor74 obj = new LowestCommonAncestor74();
        System.out.println(obj.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(9)).val);
    }
}
