import java.util.Stack;

/**
 * 用两个栈实现队列
 * @author Lucas
 * @date 2021/01/30 11:50
 */
public class CQueue06 {

    Stack stack1;
    Stack stack2;

    public CQueue06() {
        //题目要求两个栈实现队列
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void appendTail(int value) {
        //stack1用来存所有的值
        stack1.push(value);
    }

    /*public int deleteHead() {
        if(stack1.empty()){
            return -1;
        }
        *//*根据栈的特性 先进后出
        队列的特性 先进先出
        也就是在删除一个元素的时候把栈反过来然后出栈*//*
        while (!stack1.empty()) {
            //反过来存到stack2
            stack2.push(stack1.pop());
        }
        //出栈保存结果
        int res = (int) stack2.pop();
        //再返回来放回stack1 如果不返回来再插入数据会出问题 可以优化
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return res;

    }*/

    public int deleteHead() {
        /*根据栈的特性 先进后出
        队列的特性 先进先出
        也就是在删除一个元素的时候把栈反过来然后出栈*/
        //如果stack2还有值的话就没必要把stack1倒过来 因为是stack2先出
        if(stack2.empty()) {
            while (!stack1.empty()) {
                //反过来存到stack2
                stack2.push(stack1.pop());
            }
        }
        return stack2.empty()? -1 : (int) stack2.pop();
    }

    public static void main(String[] args) {
        CQueue06 obj = new CQueue06();
        obj.appendTail(3);
        System.out.println(obj.deleteHead());
    }
}
