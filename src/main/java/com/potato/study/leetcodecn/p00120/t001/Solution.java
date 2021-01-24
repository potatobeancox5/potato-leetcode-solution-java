package com.potato.study.leetcodecn.p00120.t001;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。

 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

  

 示例 1：

 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 输出：11
 解释：如下面简图所示：
 2
 3 4
 6 5 7
 4 1 8 3
 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 示例 2：

 输入：triangle = [[-10]]
 输出：-10
  

 提示：

 1 <= triangle.length <= 200
 triangle[0].length == 1
 triangle[i].length == triangle[i - 1].length + 1
 -104 <= triangle[i][j] <= 104
  

 进阶：

 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/triangle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 从上往下 依次累加
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0) {
            return 0;
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            // 遍历 list 计算每个数字
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    int val = list.get(j) + triangle.get(i - 1).get(j);
                    list.set(j, val);
                } else if (j == list.size() - 1) {
                    int val = list.get(j) + triangle.get(i - 1).get(j-1);
                    list.set(j, val);
                } else {
                    int val = list.get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i-1).get(j-1));
                    list.set(j, val);
                }
            }
        }
        // 计算最小路径和
        int minPath = triangle.get(triangle.size() - 1).get(0);
        for (int path : triangle.get(triangle.size() - 1)) {
            minPath = Math.min(minPath, path);
        }
        return minPath;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(4,1,8,3));

        int minimumTotal = solution.minimumTotal(triangle);
        System.out.println(minimumTotal);
        Assert.assertEquals(11, minimumTotal);
    }
}
