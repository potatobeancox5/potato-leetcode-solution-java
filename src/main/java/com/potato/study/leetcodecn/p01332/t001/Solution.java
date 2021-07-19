package com.potato.study.leetcodecn.p01332.t001;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1332. 删除回文子序列
 *
 * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 *
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 *
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 *
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ababa"
 * 输出：1
 * 解释：字符串本身就是回文序列，只需要删除一次。
 * 示例 2：
 *
 * 输入：s = "abb"
 * 输出：2
 * 解释："abb" -> "bb" -> "".
 * 先删除回文子序列 "a"，然后再删除 "bb"。
 * 示例 3：
 *
 * 输入：s = "baabb"
 * 输出：2
 * 解释："baabb" -> "b" -> "".
 * 先删除回文子序列 "baab"，然后再删除 "b"。
 * 示例 4：
 *
 * 输入：s = ""
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * s 仅包含字母 'a'  和 'b'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-palindromic-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 1332
    public int removePalindromeSub(String s) {
        // 其实是智力题 因为只有 ab两个字母，而且删除的子序列 ，那么最多2次都删除了 一次a 一次b
        if (null == s || s.length() == 0) {
            return 0;
        }
        // 判断s是够是 回文，是的话 直接删除
        boolean isPalindrome = true;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
            return 1;
        }
        return 2;
    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String input = "[[3,3,1,1],[2,2,1,2],[1,1,1,2]]";
//        int[][] array = LeetcodeInputUtils.inputString2IntArrayTwoDimensional(input);
//        int[][] res = solution.diagonalSort(array);
//        // [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
//        ArrayUtil.printMatrix(res);
//    }
}
