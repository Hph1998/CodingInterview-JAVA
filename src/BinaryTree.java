import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 返回某节点的父亲节点
     * @author Lucas
     * @date 2021/02/08 10:27
     * @param root 树的根节点
     * @param node 需要查找父节点的节点
     * @return TreeNode
     */
    public TreeNode getParent(TreeNode root, TreeNode node){
        if (root == null || root == node){
            return null;
        }
        if(root.left == node || root.right == node){
            return root;
        }
        getParent(root.left, node);
        getParent(root.right, node);
        return null;
    }

    /**
     * 前序遍历
     * @author Lucas
     * @date 2021/02/08 11:08
     * @param root 根节点
     * @return void
     */
    public void perOrder(TreeNode root){
        if (root != null){
            System.out.println(root.val);
            perOrder(root.left);
            perOrder(root.right);
        }
    }

    /**
     * 中序遍历
     * @author Lucas
     * @date 2021/02/08 11:10
     * @param root 根节点
     * @return void
     */
    public void inOrder(TreeNode root){
        if (root != null){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历
     * @author Lucas
     * @date 2021/02/08 11:19
     * @param root 根节点
     * @return void
     */
    public void postOrder(TreeNode root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * 层序遍历
     * @author Lucas
     * @date 2021/02/08 13:57
     * @param root 根节点
     * @return void
     */
    public void levelOrderTraverse(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        while (root != null){
            System.out.println(root.val);
            if (root.left != null){
                queue.offer(root.left);
            }
            if (root.right != null){
                queue.offer(root.right);
            }
            root = queue.poll();
        }
    }

    /**
     * 广度优先通过数组创建树
     * @author Lucas
     * @date 2021/02/08 15:19
     * @param array 数据
     * @return TreeNode
     */
    public TreeNode levelCreateTree(int[] array){
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        TreeNode node = root;
        TreeNode t;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        for (int i = 1; i < array.length; i++){
            t = new TreeNode(array[i]);
            if (node.left == null){
                node.left = t;
                queue.offer(node.left);
            }else if (node.right == null){
                node.right = t;
                queue.offer(node.right);
                node = queue.remove();
            }
        }
        return root;
    }

}
