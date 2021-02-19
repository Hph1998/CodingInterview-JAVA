/**
 * 二叉搜索树的后序遍历序列
 * @author Lucas
 * @date 2021/02/19 09:22
 */
public class VerifyPostorder33 {
    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public static boolean recur(int[] postorder, int i, int j) {
        if(i >= j) {
            return true;
        }
        int p = i;
        // 搜索二叉树找到当前根节点左子树
        while(postorder[p] < postorder[j]) {
            p++;
        }
        // m划分左右子树
        int m = p;
        // 找到右子树
        while(postorder[p] > postorder[j]) {
            p++;
        }
        // 最后p==j确定该树为是否为合法的搜索二叉树
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

}
