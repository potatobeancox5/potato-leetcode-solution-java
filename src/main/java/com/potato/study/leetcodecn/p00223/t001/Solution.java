package com.potato.study.leetcodecn.p00223.t001;

import org.junit.Assert;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 223. 矩形面积
 *
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * 示例 2：
 *
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 *  
 *
 * 提示：
 *
 * -104 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 104
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
            int bx1, int by1, int bx2, int by2) {
        // 判断 有没有重叠
        boolean hasOverlapping = getHasOverlappingFlag(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        int s1 = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        int s2 = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        // 左下 顶点和 右上
        if (hasOverlapping) {
            // 有重叠 面积求和 之后 减去 重叠部分
            int line = Math.abs(Math.max(ax1, bx1) - Math.min(ax2, bx2));
            int row = Math.abs(Math.max(ay1, by1) - Math.min(ay2, by2));
            int s3 = line * row;
            return s1 + s2 - s3;
        } else {
            // 没有重叠 直接面积求和
            return s1 + s2;
        }
    }

    /**
     * 判定是不是 交叉
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */
    private boolean getHasOverlappingFlag(int ax1, int ay1, int ax2, int ay2,
            int bx1, int by1, int bx2, int by2) {
        // 重置左右
        if (ax1 > bx1) {
            int tmp = ax1;
            ax1 = bx1;
            bx1 = tmp;

            tmp = ax2;
            ax2 = bx2;
            bx2 = tmp;

            tmp = ay1;
            ay1 = by1;
            by1 = tmp;

            tmp = ay2;
            ay2 = by2;
            by2 = tmp;
        }
        // 左下 顶点和 右上
        // 三种状态是不相交 b的左边 大于等于 a的右边
        if (bx1 >= ax2) {
            return false;
        }
        // b的下边 大于等于 a的上边
        if (by1 >= ay2) {
            return false;
        }
        // b的上边 小于等于 a的下边
        if (by2 <= ay1) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        int area = solution.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        System.out.println(area);
        Assert.assertEquals(45, area);
    }

}
