package com.potato.study.leetcodecn.p00345.t001;

/**
 * 345. 反转字符串中的元音字母
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

  

 示例 1：

 输入："hello"
 输出："holle"
 示例 2：

 输入："leetcode"
 输出："leotcede"
  

 提示：

 元音字母不包含字母 "y" 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 反转元音字母
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        // 找到左右节点 置换
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // 找到左边第一个
            while (left < right && !isVowel(arr[left])) {
                left++;
            }
            // find the first Vowel from right
            while (left < right && !isVowel(arr[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            // swap
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            left++;
            right--;
        }
        return new String(arr);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E'
                || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
                || ch == 'u' || ch == 'U';
    }
}
