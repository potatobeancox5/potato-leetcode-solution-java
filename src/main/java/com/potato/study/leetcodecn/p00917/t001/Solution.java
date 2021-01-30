package com.potato.study.leetcodecn.p00917.t001;

/**
 * 917. 仅仅反转字母
 *
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。

  

 示例 1：

 输入："ab-cd"
 输出："dc-ba"
 示例 2：

 输入："a-bC-dEf-ghIj"
 输出："j-Ih-gfE-dCba"
 示例 3：

 输入："Test1ng-Leet=code-Q!"
 输出："Qedo1ct-eeLg=ntse-T!"
  

 提示：

 S.length <= 100
 33 <= S[i].ASCIIcode <= 122 
 S 中不包含 \ or "

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-only-letters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param s
     * @return
     */
    public String reverseOnlyLetters(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            // left
            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }
            // replace
            if (left < right) {
                char ch = chars[left];
                chars[left] = chars[right];
                chars[right] = ch;
                left++;
                right--;
            }

        }
        return new String(chars);
    }
}
