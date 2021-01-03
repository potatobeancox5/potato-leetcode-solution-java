package com.potato.study.leetcodecn.p00011.t001;

import org.junit.Assert;

/**
 * 11. 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器。

  

 示例 1：



 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 示例 2：

 输入：height = [1,1]
 输出：1
 示例 3：

 输入：height = [4,3,2,1,4]
 输出：16
 示例 4：

 输入：height = [1,2,1]
 输出：2
  

 提示：

 n = height.length
 2 <= n <= 3 * 104
 0 <= height[i] <= 3 * 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/container-with-most-water
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * left = 0 right = heigt.len - 1 .
     * 当left 小于right 时， 每次计算 当前 left 和 right 对应最小高度 * 距离，更新最大值
     * 然后挑 left 和right 小的那个移动， 因为只有这样 才能保证移动之后的面积可能会比当前面积大，否则都是比当前面积小的
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        if (height.length == 1) {
            return height[0];
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left <= right) {
            int thisArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, thisArea);
            // 移动
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int area = solution.maxArea(height);
        System.out.println(area);
        Assert.assertEquals(49, area);


        height = new int[]{1,1};
        area = solution.maxArea(height);
        System.out.println(area);
        Assert.assertEquals(1, area);


        height = new int[]{4,3,2,1,4};
        area = solution.maxArea(height);
        System.out.println(area);
        Assert.assertEquals(16, area);


        height = new int[]{1,2,1};
        area = solution.maxArea(height);
        System.out.println(area);
        Assert.assertEquals(2, area);
    }


}
