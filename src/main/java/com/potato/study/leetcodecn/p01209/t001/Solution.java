package com.potato.study.leetcodecn.p01209.t001;


import org.junit.Assert;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 *
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。

 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。

 在执行完所有删除操作后，返回最终得到的字符串。

 本题答案保证唯一。

  

 示例 1：

 输入：s = "abcd", k = 2
 输出："abcd"
 解释：没有要删除的内容。
 示例 2：

 输入：s = "deeedbbcccbdaa", k = 3
 输出："aa"
 解释：
 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 再删除 "bbb"，得到 "dddaa"
 最后删除 "ddd"，得到 "aa"
 示例 3：

 输入：s = "pbbcggttciiippooaais", k = 2
 输出："ps"
  

 提示：

 1 <= s.length <= 10^5
 2 <= k <= 10^4
 s 中只含有小写英文字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 s 遇到每个字母 都往前找k个字符
     * @param s
     * @param k
     * @return
     */
    public String removeDuplicates(String s, int k) {
        StringBuilder builder = new StringBuilder();
        // 都往前找k个字符
        int appearTime = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (builder.length() == 0) {
                appearTime = 1;
                builder.append(ch);
            } else if (builder.charAt(builder.length() - 1) == ch) {
                appearTime++;
                builder.append(ch);
                // 加到一定次数 删除 并 计数删除之后的字符出现了多少次
                if (appearTime == k) {
                    // 删除啊
                    builder.delete(builder.length() - k, builder.length());
                    appearTime = 1;
                    for (int j = builder.length() - 1; j >= 1; j--) {
                        if (builder.charAt(j) == builder.charAt(j-1)) {
                            appearTime++;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                appearTime = 1;
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcd";
        int k = 2;
        String result = solution.removeDuplicates(s, k);
        System.out.println(result);
        Assert.assertEquals("abcd", result);

        s = "deeedbbcccbdaa";
        k = 3;
        result = solution.removeDuplicates(s, k);
        System.out.println(result);
        Assert.assertEquals("aa", result);

        s = "pbbcggttciiippooaais";
        k = 2;
        result = solution.removeDuplicates(s, k);
        System.out.println(result);
        Assert.assertEquals("ps", result);

    }
}
