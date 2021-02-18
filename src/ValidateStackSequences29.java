import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * @author Lucas
 * @date 2021/02/18 10:16
 */
public class ValidateStackSequences29 {

    /*public static boolean validateStackSequences(int[] pushed, int[] popped) {
        // 双指针模拟
        int p1 = 0;
        int p2 = 0;
        Stack<Integer> stack = new Stack<>();
        while (p2 != popped.length){
            // 符合栈顶跟p2指针相等就出栈并且指针后移
            if (!stack.empty() && stack.peek().equals(popped[p2])){
                stack.pop();
                p2++;
            }else {
                // p1越界且不符合上面条件 走不动了
                if (p1 >= pushed.length){
                    return false;
                }
                // 不符合上面条件 进栈且指针后移
                stack.push(pushed[p1]);
                p1++;
            }
        }
        return true;
    }*/

    public static boolean validateStackSequences(int[] pushed, int[] popped){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,2,1};
        System.out.println(validateStackSequences(pushed, popped));
    }

}
