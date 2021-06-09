package com.potato.study.leetcodecn.p01734.t001;

import java.util.Arrays;

/**
 * 1734. 解码异或后的排列
 *
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *  
 *
 * 提示：
 *
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 1. 求出 1-n的 异或和
     * 2. 求 1-n-1的异或和  encoded[len-2] encoded[len-4] 。。。
     * 3. 求 12 的异或 得到 an 然后 遍历 encode 求 异或 得到最终结果
     * @param encoded
     * @return
     */
    public int[] decode(int[] encoded) {
        int all = 0;
        int n = encoded.length + 1;
        for (int i = 1; i <= n; i++) {
            all ^= i;
        }
        int allExcludeLast = 0;
        for (int i = encoded.length - 2; i >= 0; i-=2) {
            allExcludeLast ^= encoded[i];
        }
        int last = allExcludeLast ^ all;
        int[] origin = new int[n];
        origin[n-1] = last;
        for (int i = n - 2; i >= 0; i--) {
            origin[i] = origin[i+1] ^ encoded[i];
        }
        return origin;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] encoded = new int[] {
                3,1
        };
        // [1,2,3]
        int[] decode = solution.decode(encoded);
        System.out.println(Arrays.toString(decode));
    }
}
