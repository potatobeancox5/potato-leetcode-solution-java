package com.potato.study.leetcodecn.p00022.t001;


import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

  

 示例：

 输入：n = 3
 输出：[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/generate-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 数字 value 表示 当前括号的情况 n 大于 0 表示已经有的（ 数量
     * 深度优先搜索
     * 用一个  status 标识当前的状态 leftBracketNum 标识当前的可用左括号的数量
     * builder 存储 当前的路径
     * result 存全局的结果
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int status = 0;
        int leftBracketNum = n;
        dfs(result, builder, status, leftBracketNum, n);
        return result;
    }

    /**
     * dfs 生成 遍历的结果
     * @param result
     * @param builder
     * @param status
     * @param leftBracketNum    左括号的剩余情况
     * @param n
     */
    private void dfs(List<String> result, StringBuilder builder, int status, int leftBracketNum, int n) {
        // 调试
//        System.out.println(builder.toString());
        // 没有剩下的 左括号 且 当前状态已经平衡 直接插入
        if (status == 0 && leftBracketNum == 0) {
            result.add(builder.toString());
            return;
        }
        // 处理第一个 左括号的情况
        if (leftBracketNum == n) {
            StringBuilder newBuilder = new StringBuilder(builder.toString());
            newBuilder.append("(");
            dfs(result, newBuilder, status + 1, leftBracketNum - 1, n);
        } else {
            // 非第一个的情况
            if (leftBracketNum == 0 && status > 0) {
                // 只能添加 扩回的场景
                StringBuilder newBuilder = new StringBuilder(builder.toString());
                newBuilder.append(")");
                dfs(result, newBuilder, status - 1, leftBracketNum, n);
            } else if (leftBracketNum > 0 && status == 0) {
                // 只能添加括号的场景
                StringBuilder newBuilder = new StringBuilder(builder.toString());
                newBuilder.append("(");
                dfs(result, newBuilder, status + 1, leftBracketNum - 1, n);
            } else {
                // 都可以的情况 先添加 括号 再添加扩回
                StringBuilder newBuilder = new StringBuilder(builder.toString());
                newBuilder.append("(");
                dfs(result, newBuilder, status + 1, leftBracketNum - 1, n);

                newBuilder = new StringBuilder(builder.toString());
                newBuilder.append(")");
                dfs(result, newBuilder, status - 1, leftBracketNum, n);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> list = solution.generateParenthesis(n);
        System.out.println(list);
    }
}
