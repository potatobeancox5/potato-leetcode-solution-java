package com.potato.study.leetcodecn.p00946.t001;

import org.junit.Assert;

import java.util.Stack;

/**
 * 946. 验证栈序列
 *
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。

  

 示例 1：

 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 输出：true
 解释：我们可以按以下顺序执行：
 push(1), push(2), push(3), push(4), pop() -> 4,
 push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 示例 2：

 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 输出：false
 解释：1 不能在 2 之前弹出。
  

 提示：

 0 <= pushed.length == popped.length <= 1000
 0 <= pushed[i], popped[i] < 1000
 pushed 是 popped 的排列。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/validate-stack-sequences
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 模拟法
     stack
     indexpush 记录遍历到的入栈元素

     遍历pop
     if pop i 等于 stack peek
     直接stack pop
     while pop 不等于stack
     入栈 push index++
     这如果还匹配不上 返回false
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int targetIndex = 0;
        while (targetIndex < popped.length) {
            int target = popped[targetIndex];
            if (stack.isEmpty() || stack.peek() != target) {
                if (index == pushed.length) {
                    return false;
                }
                stack.add(pushed[index++]);
            } else {
                // 相等
                stack.pop();
                targetIndex++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        boolean b = solution.validateStackSequences(pushed, popped);
        System.out.println(b);
        Assert.assertEquals(true, b);

        pushed = new int[]{1,2,3,4,5};
        popped = new int[]{4,3,5,1,2};
        b = solution.validateStackSequences(pushed, popped);
        System.out.println(b);
        Assert.assertEquals(false, b);
    }
}
