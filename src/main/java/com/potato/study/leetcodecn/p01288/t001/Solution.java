package com.potato.study.leetcodecn.p01288.t001;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1288. 删除被覆盖区间
 *
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。

 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。

 在完成所有删除操作后，请你返回列表中剩余区间的数目。

  

 示例：

 输入：intervals = [[1,4],[3,6],[2,8]]
 输出：2
 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
  

 提示：​​​​​​

 1 <= intervals.length <= 1000
 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 对于所有的 i != j：intervals[i] != intervals[j]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-covered-intervals
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 覆盖区间 剔除
     * 排序 按照 区间大小排序，遍历排序后结果 进行合并判定
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[1] - o2[0]) - (o1[1] - o1[0]);
            }
        });
        // 存放没有 覆盖的各个区间
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (result.isEmpty()) {
                result.add(intervals[i]);
                continue;
            }
            // 非空时 需要遍历 list 看是否存在覆盖的情况
            boolean hasCoverd = false;
            for (int[] target : result) {
                if (target[1] - target[0] < intervals[i][1] - intervals[i][0]) {
                    break;
                }
                if (isCover(target, intervals[i])) {
                    hasCoverd = true;
                    break;
                }
            }
            if (!hasCoverd) {
                result.add(intervals[i]);
            }
        }
        return result.size();
    }

    /**
     * 判断 interval2 是不是 被 interval1 覆盖
     * @return
     */
    private boolean isCover(int[] interval1, int[] interval2) {
        return interval1[0] <= interval2[0] && interval2[1] <= interval1[1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1,4},{3,6},{2,8}};
        int res = solution.removeCoveredIntervals(intervals);
        System.out.println(res);
        Assert.assertEquals(2, res);
    }
}
