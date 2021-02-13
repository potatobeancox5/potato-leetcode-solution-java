package com.potato.study.leetcodecn.p00739.t001;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/daily-temperatures
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用 一个 栈 记录 当前 还没有 观测到 更高一些 温度的天数
     * 遍历 数组 tem
     * 如果 当前 第一个 入栈
     * 否则 判断当前温度是否比 栈顶温度高，
     *      高的话 一直出栈，记录天数，并记录，不高的话 当前温度入栈
     *
     * 注意 栈中记录的是 index
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indexStack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (indexStack.isEmpty()) {
                indexStack.push(i);
                continue;
            }
            // 栈里边有元素 比较先
            while (!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]) {
                Integer index = indexStack.pop();
                res[index] = i - index;
            }
            indexStack.push(i);
        }
        // 剩下元素没有处理，不管了
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temp = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        // [1, 1, 4, 2, 1, 1, 0, 0]
        int[] res = solution.dailyTemperatures(temp);
        System.out.println(Arrays.toString(res));
    }
}
