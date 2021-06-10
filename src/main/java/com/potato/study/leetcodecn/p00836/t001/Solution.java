package com.potato.study.leetcodecn.p00836.t001;

import org.junit.Assert;

/**
 * 836. 矩形重叠
 *
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。
 *
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * 示例 3：
 *
 * 输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * 输出：false
 *  
 *
 * 提示：
 *
 * rect1.length == 4
 * rect2.length == 4
 * -109 <= rec1[i], rec2[i] <= 109
 * rec1[0] <= rec1[2] 且 rec1[1] <= rec1[3]
 * rec2[0] <= rec2[2] 且 rec2[1] <= rec2[3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-overlap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * 左    下               右   上
     * (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标
     * 将靠左边的放在 rec1
     *
     *
     *
     * 那么三种情况 不重叠
     * rec2 的下边界 小于等于 rec1 的上边界
     * rec2 的左边界 大于等于 rec1 的右边界
     * rec2 的上边界 小于等于 rec1的下边界
     *
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3]
                || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }

        // 置换
        if (rec1[0] > rec2[0]) {
            int[] tmp = rec1;
            rec1 = rec2;
            rec2 = tmp;
        }
        // 左0,下1,右2,上3

        // rec2 的下边界 大于等于 rec1 的上边界
        if (rec2[1] >= rec1[3]) {
            return false;
        }
        // rec2 的左边界 大于等于 rec1 的右边界
        if (rec2[0] >= rec1[2]) {
            return false;
        }
        // rec2 的上边界 小于等于 rec1的下边界
        if (rec2[3] <= rec1[1]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] rec1 = new int[]{
                0,0,2,2
        };
        int[] rec2 = new int[] {
                1,1,3,3
        };
        boolean res = solution.isRectangleOverlap(rec1, rec2);
        System.out.println(res);
        Assert.assertEquals(true, res);


        rec1 = new int[]{
                -1,0,1,1
        };
        rec2 = new int[] {
                0,-1,0,1
        };
        res = solution.isRectangleOverlap(rec1, rec2);
        System.out.println(res);
        Assert.assertEquals(false, res);

    }
}
