import java.util.*;

/**
 * 从上到下打印二叉树 III
 * @author Lucas
 * @date 2021/02/18 11:56
 */
public class LevelOrder32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--){
                TreeNode t = queue.poll();
                list.add(t.val);
                if (t.left != null){
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }
            }
            // 对比上一题 只需要判断是偶数层的把list反转就可以了
            if (res.size() % 2 == 1){
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }

}
