/**
 * 二叉搜索树与双向链表
 * @author Lucas
 * @date 2021/02/20 09:36
 */
public class TreeToDoublyList36 {

    TreeNode pre, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null){
            return null;
        }
        dfs(root);
        // 处理头节点和尾节点指针
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(TreeNode cur){
        // 中序遍历
        if (cur == null){
            return;
        }
        dfs(cur.left);
        if(pre != null) {
            // 反之 让前驱节点指向当前节点
            pre.right = cur;
        }
        else {
            // 如果是第一个节点 则用head保存
            head = cur;
        }
        // 当前节点指向前驱节点
        cur.left = pre;
        // pre保留前驱
        pre = cur;
        dfs(cur.right);
    }

}
