import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * @author Lucas
 * @date 2021/02/25 11:36
 */
public class LengthOfLongestSubstring48 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0;
        int tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            // 获取索引 i
            int i = dic.getOrDefault(s.charAt(j), -1);
            // 更新哈希表
            dic.put(s.charAt(j), j);
            // dp[j - 1] -> dp[j]
            if (tmp < j - i){
                tmp += 1;
            }else {
                tmp = j - i;
            }
            // max(dp[j - 1], dp[j])
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring48 obj = new LengthOfLongestSubstring48();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}
