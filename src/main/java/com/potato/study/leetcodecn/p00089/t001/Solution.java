package com.potato.study.leetcodecn.p00089.t001;


import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 *
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。

 格雷编码序列必须以 0 开头。

  

 示例 1:

 输入: 2
 输出: [0,1,3,2]
 解释:
 00 - 0
 01 - 1
 11 - 3
 10 - 2

 对于给定的 n，其格雷编码序列并不唯一。
 例如，[0,2,3,1] 也是一个有效的格雷编码序列。

 00 - 0
 10 - 2
 11 - 3
 01 - 1
 示例 2:

 输入: 0
 输出: [0]
 解释: 我们定义格雷编码序列必须以 0 开头。
      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
      因此，当 n = 0 时，其格雷编码序列为 [0]。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/gray-code
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 其实是找规律的题
     * 假设初始为 00
     * 接下来的数字是 将其目前最高位的0 + 1 —— 01
     * 然后的数字是 11 ， 10
     * 规律：
     *  记录当前最高位置的1，初始是1，一次是2，4，8，16
     *  每次用当前的最高位 i + 之前的res的后序遍历
     *
     *  比如当前是
     *  00
     *  01
     *  11
     *  10
     *
     *  那么后序遍历是
     *
     *  10
     *  11
     *  01
     *  00
     *
     *
     *  当前的变化
     *  000
     *  001
     *  011
     *  010
     *
     *  加上最高位是
     *
     *  110
     *  111
     *  101
     *  100
     *
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int high = 1;
        // 每个位数生成一次
        for (int i = 0; i < n; i++) {
            // 用当前的高位 + 之前结果的倒序遍历
            int startIndex = res.size() - 1;
            for (int j = startIndex; j >= 0 ; j--) {
                int tmp = high + res.get(j);
                // 新的结果
                res.add(tmp);
            }
            // high 需要往前移动一个位置
            high *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.grayCode(2);
        System.out.println(list);
        Assert.assertEquals(Lists.newArrayList(0,1,3,2), list);

        list = solution.grayCode(0);
        System.out.println(list);
        Assert.assertEquals(Lists.newArrayList(0), list);
    }
}
