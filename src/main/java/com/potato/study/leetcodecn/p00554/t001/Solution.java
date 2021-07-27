package com.potato.study.leetcodecn.p00554.t001;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. 砖墙
 *
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：

 'A' : Absent，缺勤
 'L' : Late，迟到
 'P' : Present，到场
 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。

 你需要根据这个学生的出勤记录判断他是否会被奖赏。

 示例 1:

 输入: "PPALLP"
 输出: True
 示例 2:

 输入: "PPALLL"
 输出: False

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。

 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。

 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。

  

 示例 1：


 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 输出：2
 示例 2：

 输入：wall = [[1],[1],[1]]
 输出：3
  
 提示：

 n == wall.length
 1 <= n <= 104
 1 <= wall[i].length <= 104
 1 <= sum(wall[i].length) <= 2 * 104
 对于每一行 i ，sum(wall[i]) 是相同的
 1 <= wall[i][j] <= 231 - 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/brick-wall
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 554 使用map 记录每个缝隙对应的转数量，求其最大值
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> list = wall.get(i);
            int len = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                len += list.get(j);
                countMap.put(len, countMap.getOrDefault(len, 0) + 1);
            }
        }
        // 遍历map 求最大值
        int max = 0;
        for (int count : countMap.values()) {
            max = Math.max(count, max);
        }
        return wall.size() - max;
    }

}
