import sun.reflect.generics.tree.Tree;

/**
 * 二叉树及操作
 * @author Lucas
 * @date 2021/02/07 22:18
 */
public class BinaryTree {

    /**
     * 清空某个子树的所有节点
     * @author Lucas
     * @date 2021/02/07 22:20
     * @param root 当前节点位置
     * @return void
     */
    public void clear(TreeNode root){
        if (root != null){
            clear(root.left);
            clear(root.right);
            root = null;
        }
    }

    /**
     * 获取某节点所在的层数
     * @author Lucas
     * @date 2021/02/08 00:02
     * @param root 当前节点位置
     * @return int
     */
    public int heigh(TreeNode root){
        if (root == null){
            return 0;
        }else {
            int l = heigh(root.left);
            int r = heigh(root.right);
            return l > r ? (l + 1) : (r + 1);
        }
    }

    /**
     * 获取二叉树的节点个数
     * @author Lucas
     * @date 2021/02/08 00:06
     * @param root 根节点
     * @return int
     */
    public int size(TreeNode root){
        if (root == null){
            return 0;
        }else{
            return 1 + size(root.left) + size(root.right);
        }
    }
}
