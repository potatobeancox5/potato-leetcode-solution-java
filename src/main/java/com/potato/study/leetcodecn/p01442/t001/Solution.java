package com.potato.study.leetcodecn.p01442.t001;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 *
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * 示例 2：
 *
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 * 示例 3：
 *
 * 输入：arr = [2,3]
 * 输出：0
 * 示例 4：
 *
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 * 示例 5：
 *
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/solution/xing-cheng-liang-ge-yi-huo-xiang-deng-sh-jud0/
     * 代码 很简单 主要是数学推导 那我们就推导下
     *
     * 设 s（i） 代表 arr 的 前i个数字 组成的异或结果
     * 因此
     * s（0） = 0;
     * s（1） = 0 ^ arr(0) = arr(0)
     * s（i） = arr（0）^ arr(1) ..... arr(i-1) (i个)
     *
     * 由题目 判定相等条件可知
     * 0≤i<j≤k<n
     *
     * 初始值 a = arr[0]
     *
     * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] = s(j) ^ s(i)
     * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k] = s(k+1) ^ s(j)
     *
     * a = s(j) ^ s(i)
     *      其中  s(j) = arr（0）^ arr(1) ..... arr(j-1)
     *            s(i) = arr（0）^ arr(1) ..... arr(i-1)
     *
     *
     * b = s[k+1] ^ s(j)
     *
     * 这样 另 a == b ==》 s(i) == s(k+1)
     * 也就是说 只要锁定 i 和 k ，中间的每一个 j 都是一组
     *
     * 因此
     * 1. 求一个 异或的前缀和
     * 2. 遍历 arr 两层循环，锁定 i和k，计算中间j 有多少中取值
     *  判定 有多少个  s(i) == s(k+1)  其中  i 和 k 值得是 s的个数 下标
     *
     *
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int[] mask = new int[arr.length + 1];
        mask[0] = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            mask[i] = mask[i-1] ^ arr[i-1];
        }
        // 这块要使用题目含义的ijk
        int totalCount = 0;
        int n = arr.length;
        // i < arr.length
        for (int i = 0; i < n; i++) {
            // k < arr.length
            for (int k = i+1; k < n; k++) {
                // 判断 满足条件不
                int a = mask[i];
                int b = mask[k+1];
                if (a != b) {
                    continue;
                }
                // 满足条件 求j数量
                int j = k - i;
                totalCount += j;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{
                2,3,1,6,7
        };
        int i = solution.countTriplets(arr);
        System.out.println(i);
        Assert.assertEquals(4, i);

        arr = new int[]{
                1,1,1,1,1
        };
        i = solution.countTriplets(arr);
        System.out.println(i);
        Assert.assertEquals(10, i);
    }
}
