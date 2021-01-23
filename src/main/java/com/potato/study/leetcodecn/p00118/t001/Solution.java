package com.potato.study.leetcodecn.p00118.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角

 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 5
 输出:
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/pascals-triangle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 模拟 法
     * 初始 0 直接返回
     * 初始 1 生成 list 1
     * 否则 遍历 之前list 如果是 index = 1， index last len = 1，其余的index 为i + i+ 1
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (0 == numRows) {
            return resultList;
        }
        List<Integer> initList = new ArrayList<>();
        initList.add(1);
        resultList.add(initList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastLayerList = resultList.get(resultList.size() - 1);
            List<Integer> thisLayerList = new ArrayList<>();
            for (int j = 0; j <= lastLayerList.size(); j++) {
                if (j == 0 || j == lastLayerList.size()) {
                    thisLayerList.add(1);
                } else {
                    thisLayerList.add(lastLayerList.get(j) + lastLayerList.get(j - 1));
                }
            }
            resultList.add(thisLayerList);
        }
        return resultList;
    }
}
