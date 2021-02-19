import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * @author Lucas
 * @date 2021/02/19 09:55
 */
public class PathSum34 {

    // 记录结果
    LinkedList<List<Integer>> res = new LinkedList<>();
    // 记录路径
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    public void recur(TreeNode root, int tar) {
        // 终止条件
        if(root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        // 满足到达叶子节点且路径和为sum
        if(tar == 0 && root.left == null && root.right == null) {
            // 结果集加入该路径
            res.add(new LinkedList<>(path));
        }
        // 前序遍历
        recur(root.left, tar);
        recur(root.right, tar);
        // 向上回溯
        path.removeLast();
    }


}
