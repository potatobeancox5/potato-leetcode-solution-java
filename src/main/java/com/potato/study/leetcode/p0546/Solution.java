package com.potato.study.leetcode.p0546;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         546. Remove Boxes
 * 
 *         Given several boxes with different colors represented by different positive numbers.
You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
Find the maximum points you can get.

Example 1:
Input:

[1, 3, 2, 2, 2, 3, 4, 3, 1]
Output:
23
Explanation:
[1, 3, 2, 2, 2, 3, 4, 3, 1]
----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
----> [1, 3, 3, 3, 1] (1*1=1 points)
----> [1, 1] (3*3=9 points)
----> [] (2*2=4 points)
Note: The number of boxes n would not exceed 100.
 * 
 * 
 *         思路：
 *
 *        https://www.cnblogs.com/Dylan-Java-NYC/p/11660827.html
 *       
 *          
 */
public class Solution {

    /**
     * 递归实现
     * @param boxes
     * @return
     */
    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        int[][][] dp = new int[len][len][len];
        return removeBoxesAndGet(boxes, dp, 0, len - 1, 0);
    }


    /**
     * 计算 dp left right k 中能取得的最大值
     * @param boxes
     * @param dp
     * @param left      左边
     * @param right     右边
     * @param k         right 后面连着 k 个字符
     * @return
     */
    private int removeBoxesAndGet(int[] boxes, int[][][] dp, int left, int right, int k) {
        // 边界 搞啥呢 左边比右边还往右
        if (left > right) {
            return 0;
        }
        // 从right开始找到 第一个不是 right 字符的位置，并修改计数器
        while (left < right && boxes[right] == boxes[right-1]) {
            right--;
            k++;
        }

        // 剪枝条件
        if (dp[left][right][k] > 0) {
            return dp[left][right][k];
        }
        // 如果 把right 之后的盒子都撤了 能那多少分 等于 从left开始 到right -1 0 个连续
        int result = removeBoxesAndGet(boxes, dp, left, right - 1, 0) + (1+k) * (1+k);
        // 遍历其他移除的可能
        for (int i = left; i < right; i++) {
            // 如果i位置和 right位置相同，那么 除去中间位置 然后计算 价格
            if (boxes[i] == boxes[right]) {
                // left - i 连续 位置 k+1(1是第i位置贡献的) + 其他位置能得到的值
                result = Math.max(result, removeBoxesAndGet(boxes, dp, left, i, k + 1) + removeBoxesAndGet(boxes, dp, i + 1, right-1, 0));
            }
        }
        // 设置dp
        dp[left][right][k] = result;
        return result;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
		int res = solution.removeBoxes(boxes);
		System.out.println(res);
        Assert.assertEquals(23, res);
    }
}
