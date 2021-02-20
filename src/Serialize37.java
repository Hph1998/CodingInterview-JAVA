import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 * @author Lucas
 * @date 2021/02/20 10:25
 */
public class Serialize37 {

    public static String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }
        // 不涉及线程安全 StringBuilder更快
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 层序遍历
        while (!queue.isEmpty()){
            TreeNode t = queue.poll();
            // 当前节点不为空 则追加值 并把左右节点入队
            if (t != null){
                res.append(t.val + ",");
                queue.add(t.left);
                queue.add(t.right);
            }else {
                // 反之追加null
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public static TreeNode deserialize(String data) {
        if ("[]".equals(data)){
            return null;
        }
        String[] array = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        // 循环每次都把当前结点的左右孩子加上
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!array[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(array[i]));
                queue.add(node.left);
            }
            i++;
            if(!array[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(array[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.levelCreateTree(new Integer[]{1,2,3,null,null,4,5});
        System.out.println(serialize(root));
        deserialize("[1, 2, 3, null, null, 4, 5, null, null, null, null, null, null, null, null]");
    }


}
