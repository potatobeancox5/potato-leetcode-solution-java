package com.potato.study.leetcodecn.p01725.t001;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 1725. 可以形成最大正方形的矩形数目
 *
 * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。

 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。

 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。

 返回可以切出边长为 maxLen 的正方形的矩形 数目 。

  

 示例 1：

 输入：rectangles = [[5,8],[3,9],[5,12],[16,5]]
 输出：3
 解释：能从每个矩形中切出的最大正方形边长分别是 [5,3,5,5] 。
 最大正方形的边长为 5 ，可以由 3 个矩形切分得到。
 示例 2：

 输入：rectangles = [[2,3],[3,7],[4,3],[3,7]]
 输出：3
  

 提示：

 1 <= rectangles.length <= 1000
 rectangles[i].length == 2
 1 <= li, wi <= 109
 li != wi


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-rectangles-that-can-form-the-largest-square
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 一遍数组 使用 countMap 存情况，找到最大的边长 返回 计数情况
     * @param rectangles
     * @return
     */
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            int target = Math.min(rectangles[i][0], rectangles[i][1]);
            Integer count = countMap.getOrDefault(target, 0);
            count++;
            countMap.put(target, count);
        }
        // 遍历数组 找到最大的key
        int max = 0;
        for (Integer key : countMap.keySet()) {
            max = Math.max(max, key);
        }
        return countMap.get(max);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rectangles = new int[][] {
                {5,8},{3,9},{5,12},{16,5}
        };
        int count = solution.countGoodRectangles(rectangles);
        System.out.println(count);
        Assert.assertEquals(3, count);
    }
}
