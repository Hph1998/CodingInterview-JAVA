import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k大节点
 * @author Lucas
 * @date 2021/03/01 09:54
 */
public class KthLargest55 {

    int res;
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node){
        // 以右 -> 根 -> 左的方式遍历树 即可得到倒序 方便查找第k大节点
        if (node == null){
            return;
        }
        dfs(node.right);
        // k == 0 已经找到 提前跳出树的遍历
        if (k == 0){
            return;
        }
        // 找到第K大节点 赋值res
        if (--k == 0){
            res = node.val;
        }
        dfs(node.left);
    }

}
