package com.potato.study.leetcodecn.p01051.t001;

import org.junit.Assert;

/**
 * 1051. 高度检查器
 *
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。

 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。

 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。

  

 示例：

 输入：heights = [1,1,4,2,1,3]
 输出：3
 解释：
 当前数组：[1,1,4,2,1,3]
 目标数组：[1,1,1,2,3,4]
 在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。
 在下标 4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。
 在下标 5 处（从 0 开始计数）出现 3 vs 4 ，所以我们必须移动这名学生。
 示例 2：

 输入：heights = [5,1,2,3,4]
 输出：5
 示例 3：

 输入：heights = [1,2,3,4,5]
 输出：0
  

 提示：

 1 <= heights.length <= 100
 1 <= heights[i] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/height-checker
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     *
     *  https://leetcode-cn.com/problems/height-checker/solution/onjie-fa-yong-shi-yu-nei-cun-ji-bai-100-javayong-h/
     *
     * 内部逻辑 就是 比较 排序后的数字 与当前数字的差异个数
     * 因为有范围 可以直接进行计数，然后 遍历计数结果 与 heights 进行比较，记录mismatch 个数
     * mismatch个数就是 最终的移动个数
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        // 1 <= heights[i] <= 100
        int[] count = new int[101];
        // 计数
        for (int height : heights) {
            count[height]++;
        }
        // 遍历计数数组和 heights 进行匹配 匹配不上进行计数
        int mismatchCount = 0;
        int index = 0;
        for (int i = 0; i < 101; i++) {
            if (count[i] == 0) {
                continue;
            }
            while (count[i] > 0) {
                if (i != heights[index]) {
                    mismatchCount++;
                }
                index++;
                count[i]--;
            }
        }
        return mismatchCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = new int[] {
                1,1,4,2,1,3
        };
        int num = solution.heightChecker(heights);
        System.out.println(num);
        Assert.assertEquals(3, num);
    }
}
