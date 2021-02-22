import java.util.*;

/**
 * 字符串的排列
 * @author Lucas
 * @date 2021/02/22 09:26
 */
public class Permutation38 {

    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int x){

        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) {
                continue; // 重复，因此剪枝
            }
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }

    }

    public void swap(int a, int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String[] args) {
        Permutation38 permutation38 = new Permutation38();
        System.out.println(Arrays.toString(permutation38.permutation("abc")));
    }

}
