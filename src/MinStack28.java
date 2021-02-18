import java.util.Stack;

/**
 * 包含min函数的栈
 * @author Lucas
 * @date 2021/02/10 11:16
 */
public class MinStack28 {

    Stack<Integer> A;
    Stack<Integer> B;

    public MinStack28() {
        // 用两个栈实现 A为所有数据 B为递减
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        // 插入操作时 判断B的栈顶比当前插入数据大才插入 这样就能时刻取出最小值了
        if (B.empty() || B.peek() >= x){
            B.push(x);
        }
    }

    public void pop() {
        // A出栈时判断是否跟B栈顶一样 一样则B也出栈
        if (A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
        MinStack28 minStack = new MinStack28();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}
