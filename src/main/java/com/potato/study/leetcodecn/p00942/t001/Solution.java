package com.potato.study.leetcodecn.p00942.t001;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 942. 增减字符串匹配
 *
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

 如果 S[i] == "I"，那么 A[i] < A[i+1]
 如果 S[i] == "D"，那么 A[i] > A[i+1]
  

 示例 1：

 输入："IDID"
 输出：[0,4,1,3,2]
 示例 2：

 输入："III"
 输出：[0,1,2,3]
 示例 3：

 输入："DDI"
 输出：[3,2,0,1]
  

 提示：

 1 <= S.length <= 10000
 S 只包含字符 "I" 或 "D"。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/di-string-match
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用left right 记录下一个使用的数字
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        int n = s.length();
        int left = 0;
        int right = n;
        int[] result = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if ('I' == s.charAt(i)) {
                result[i] = left++;
            } else {
                result[i] = right--;
            }
        }
        // 最后一个数字
        if (left == right) {
            result[s.length()] = left;
        } else {
            throw new RuntimeException("不可能出现的情况");
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "IDID";
        int[] min = solution.diStringMatch(s);
        // [0,4,1,3,2]
        System.out.println(Arrays.toString(min));
    }
}
