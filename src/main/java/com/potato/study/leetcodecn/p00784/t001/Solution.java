package com.potato.study.leetcodecn.p00784.t001;

import java.util.ArrayList;
import java.util.List;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 784. 字母大小写全排列
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 *  
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *  
 *
 * 提示：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param s
     * @return
     */
    public List<String> letterCasePermutation(String s) {
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        getLetterCasePermutation(builder, s, 0, result);
        return result;
    }


    private void getLetterCasePermutation(StringBuilder builder, String s,
            int index, List<String> result) {
        // 终止条件 如果 index 到了最后 那就插入
        if (index >= s.length()) {
            result.add(builder.toString());
            return;
        }
        // 遍历当前位置 修改 index 上的字符 对于index 位置 数据进行修改
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            builder.append(s.charAt(index));
            index++;
        }
        if (index >= s.length()) {
            result.add(builder.toString());
            return;
        }
        char ch = s.charAt(index);
        StringBuilder newStringBuilder = new StringBuilder(builder);
        newStringBuilder.append(Character.toLowerCase(ch));
        getLetterCasePermutation(newStringBuilder, s, index + 1, result);

        newStringBuilder = new StringBuilder(builder);
        newStringBuilder.append(Character.toUpperCase(ch));
        getLetterCasePermutation(newStringBuilder, s, index + 1, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a1b2";
        List<String> list = solution.letterCasePermutation(s);
        // ["a1b2", "a1B2", "A1b2", "A1B2"]
        System.out.println(list);
    }
}
