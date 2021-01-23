package com.potato.study.leetcodecn.p00119.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II

 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 3
 输出: [1,3,3,1]
 进阶：

 你可以优化你的算法到 O(k) 空间复杂度吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex <= 0) {
            return list;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> layerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    layerList.add(1);
                    continue;
                }
                layerList.add(list.get(j-1) + list.get(j));
            }
            list = layerList;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> row = solution.getRow(3);
        System.out.println(row);

    }
}
