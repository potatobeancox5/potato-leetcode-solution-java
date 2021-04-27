package com.potato.study.leetcodecn.p00386.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 386. 字典序排数
 *
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。

 例如，

 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。

 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 递归实现
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        // 遍历 1-9 生成第一层数字
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            getLexicalOrderString(result, n, i);
        }
        return result;
    }


    /**
     * 递归 生成 字典序数字 并发数字放入 result 中
     * @param result       结果
     * @param n            总的数字大小
     * @param currentNum   当前遍历的数字
     */
    private void getLexicalOrderString(List<Integer> result, int n, int currentNum) {
        if (currentNum > n) {
            return;
        }
        result.add(currentNum);
        // 生成下一个数字 递归求解
        for (int i = 0; i < 10; i++) {
            getLexicalOrderString(result, n, 10 * currentNum + i);
        }
    }


}
