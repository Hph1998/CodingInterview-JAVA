import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 II
 * @author Lucas
 * @date 2021/02/18 11:07
 */
public class LevelOrder31 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            // 这里实现分层就很秀
            for (int i = queue.size(); i > 0; i--){
                TreeNode t = queue.poll();
                temp.add(t.val);
                if (t.left != null){
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

}
