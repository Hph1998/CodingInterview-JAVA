/**
 * 树的子结构
 * @author Lucas
 * @date 2021/02/07 17:59
 */
public class IsSubStructure24 {


    /**
     * 对A先序遍历 B不动
     * @author Lucas
     * @date 2021/02/08 23:31
     * @param A 给定树
     * @param B 子结构
     * @return boolean
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        // 递归出口
        if (A == null || B == null) {
            return false;
        }

        return compare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * A，B比较判断B是否为A的子结构
     * @author Lucas
     * @date 2021/02/08 23:32
     * @param A 给定树
     * @param B 子结构
     * @return boolean
     */
    public static boolean compare(TreeNode A, TreeNode B){
        // B为空时 证明已经匹配完成
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        }
        // 递归A B同时向左或向右
        return compare(A.left, B.left) && compare(A.right, B.right);
    }
    
    
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode A = binaryTree.levelCreateTree(new int[]{1, 0, 1, -4, -3});
        TreeNode B = binaryTree.levelCreateTree(new int[]{1, -4});
        System.out.println(isSubStructure(A, B));
    }
}
