package com.potato.study.leetcodecn.p00541.t001;


import org.junit.Assert;

/**
 * 541. 反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。

 如果剩余字符少于 k 个，则将剩余字符全部反转。
 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
  

 示例:

 输入: s = "abcdefg", k = 2
 输出: "bacdfeg"
  

 提示：

 该字符串只包含小写英文字母。
 给定字符串的长度和 k 在 [1, 10000] 范围内。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-string-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        // 找到k 个字符 判断当前是第几个k ，奇数个遍进行 转换
        char[] chars = s.toCharArray();
        int count = 0;
        boolean needReverse = true;
        for (int i = 0; i < chars.length; i++) {
            count++;
            if (count % k == 0) {
                if (needReverse) {
                    // 反转
                    int left = i - k + 1;
                    int right = i;
                    while (left < right) {
                        char tmp = chars[right];
                        chars[right] = chars[left];
                        chars[left] = tmp;
                        // 往下走
                        left++;
                        right--;
                    }
                    needReverse = false;
                } else {
                    needReverse = true;
                }
            }
        }

        // 最后几个
        if (needReverse && count <= k) {
            int left = s.length() - count;
            int right = s.length() - 1;
            while (left < right) {
                char tmp = chars[right];
                chars[right] = chars[left];
                chars[left] = tmp;
                // 往下走
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abcdefg";
        int k = 2;
        String s = solution.reverseStr(str, k);
        System.out.println(s);
        Assert.assertEquals("bacdfeg", s);


        k = 8;
        s = solution.reverseStr(str, k);
        System.out.println(s);
        Assert.assertEquals("gfedcba", s);
    }



}
