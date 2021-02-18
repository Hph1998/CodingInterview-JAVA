import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * @author Lucas
 * @date 2021/02/18 10:51
 */
public class LevelOrder30 {
    public int[] levelOrder(TreeNode root) {
        // 广度优先借助队列
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while (root != null){
            ans.add(root.val);
            // 判断是否有左右子树，有则进队列
            if (root.left != null){
                queue.offer(root.left);
            }
            if (root.right != null){
                queue.offer(root.right);
            }
            // 先进先出原则
            root = queue.poll();
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length ; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
