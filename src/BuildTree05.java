import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName BuildTree05.java
 * @Description 重建二叉树
 * @createTime 2021年01月27日 15:21:00
 */
public class BuildTree05 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 ){
            return null;
        }
        //前序遍历第一个元素必定是根结点
        TreeNode root = new TreeNode(preorder[0]);
        //标记中序遍历根结点的位置
        int tag = 0;
        for (int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                tag = i;
                break;
            }
        }
        //中序遍历根结点左边的就构成左子树
        int[] leftTreeI = Arrays.copyOf(inorder, tag);
        //前序遍历也找到左子树
        int[] leftTreeP = Arrays.copyOfRange(preorder, 1, 1 + leftTreeI.length);
        //递归左分支
        root.left = buildTree(leftTreeP, leftTreeI);
        //中序遍历根结点右边的就构成右子树
        int[] rightTreeI = Arrays.copyOfRange(inorder,  tag + 1, inorder.length);
        //前序遍历也找到左子树
        int[] rightTreeP = Arrays.copyOfRange(preorder, preorder.length - rightTreeI.length, preorder.length);
        //递归右分支
        root.right = buildTree(rightTreeP, rightTreeI);
        return root;
    }


    public static void main(String[] args) {

        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{3,2,1};
        buildTree(preorder,inorder);


    }

}
