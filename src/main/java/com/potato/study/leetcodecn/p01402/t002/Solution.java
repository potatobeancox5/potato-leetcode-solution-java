package com.potato.study.leetcodecn.p01402.t002;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1402. 做菜顺序
 *
 * 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。

 一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，也就是 time[i]*satisfaction[i] 。

 请你返回做完所有菜 「喜爱时间」总和的最大值为多少。

 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。

  

 示例 1：

 输入：satisfaction = [-1,-8,0,5,-9]
 输出：14
 解释：去掉第二道和最后一道菜，最大的喜爱时间系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。
 示例 2：

 输入：satisfaction = [4,3,2]
 输出：20
 解释：按照原来顺序相反的时间做菜 (2*1 + 3*2 + 4*3 = 20)
 示例 3：

 输入：satisfaction = [-1,-4,-5]
 输出：0
 解释：大家都不喜欢这些菜，所以不做任何菜可以获得最大的喜爱时间系数。
 示例 4：

 输入：satisfaction = [-2,5,-1,0,3,-3]
 输出：35
  

 提示：

 n == satisfaction.length
 1 <= n <= 500
 -10^3 <= satisfaction[i] <= 10^3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reducing-dishes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * 这道题可以使用贪心思想解
     *
     * 排序
     * 如果
     * a1 + a2 + a3 > 0 即可选择 a1 + a2 + a3
     * 因为每次多选一个数字 总和 增加 a1 + a2 + a3
     * @param satisfaction
     * @return
     */
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        List<Integer> list = new LinkedList<>();
        int tmp = 0;
        for (int i = satisfaction.length - 1; i >= 0 ; i--) {
            if (tmp + satisfaction[i] >= 0) {
                list.add(0, satisfaction[i]);
                tmp += satisfaction[i];
            }
        }
        int sum = 0;
        int i = 1;
        for (Integer ele : list) {
            sum += ele * i;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] satisfaction = new int[]{-1,-8,0,5,-9};
        int max = solution.maxSatisfaction(satisfaction);
        System.out.println(max);
        Assert.assertEquals(14, max);


        satisfaction = new int[]{4,3,2};
        max = solution.maxSatisfaction(satisfaction);
        System.out.println(max);
        Assert.assertEquals(20, max);

        satisfaction = new int[]{-1,-4,-5};
        max = solution.maxSatisfaction(satisfaction);
        System.out.println(max);
        Assert.assertEquals(0, max);


        satisfaction = new int[]{-2,5,-1,0,3,-3};
        max = solution.maxSatisfaction(satisfaction);
        System.out.println(max);
        Assert.assertEquals(35, max);
    }
}
