package com.potato.study.leetcodecn.p00207.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

/**
 * 207. 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

  

 示例 1：

 输入：numCourses = 2, prerequisites = [[1,0]]
 输出：true
 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 示例 2：

 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 输出：false
 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
  

 提示：

 1 <= numCourses <= 105
 0 <= prerequisites.length <= 5000
 prerequisites[i].length == 2
 0 <= ai, bi < numCourses
 prerequisites[i] 中的所有课程对 互不相同

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/course-schedule
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     *
     * 使用 map 记录 prerequisites key 是出发点 value 达到点 list
     * 使用 map 记录 每个节点的出入度 key 是节点 num， value 是该节点的入度
     * 每个遍历 map 找到 入读为0的 点  （删除），然后依次修改 到达点的入读 直到结束
     *
     *
     * 最后 如果某次 map 没有发现 出度为 0 的点 ，那么 返回false  否则 为空 返回false
     *
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegreeMap.put(i, 0);
        }
        Map<Integer, List<Integer>> targetListMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int startIndex = prerequisite[1];
            int endIndex = prerequisite[0];
            // 2. 使用 map 记录 每个节点的出入度 key 是节点 num， value 是该节点的入度
            Integer count = inDegreeMap.getOrDefault(endIndex, 0);
            count++;
            inDegreeMap.put(endIndex, count);
            // 1. 使用 map 记录 prerequisites key 是出发点 value 达到点 list
            List<Integer> list = targetListMap.getOrDefault(startIndex, new ArrayList<>());
            list.add(endIndex);
            targetListMap.put(startIndex, list);
        }
        // 3. 遍历 2的map
        while (!inDegreeMap.isEmpty()) {
            Integer removeIndex = null;
            for (Map.Entry<Integer, Integer> entry : inDegreeMap.entrySet()) {
                if (entry.getValue() == 0) {
                    removeIndex = entry.getKey();
                    break;
                }
            }
            // 如果某次 map 没有发现 出度为 0 的点 ，那么 返回false
            if (removeIndex == null) {
                return false;
            }
            inDegreeMap.remove(removeIndex);
            // 更改其他的入度
            List<Integer> list = targetListMap.get(removeIndex);
            if (null == list) {
                continue;
            }
            for (int index : list) {
                if (!inDegreeMap.containsKey(index)) {
                    continue;
                }
                Integer count = inDegreeMap.get(index);
                count--;
                inDegreeMap.put(index, count);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        boolean b = solution.canFinish(numCourses, prerequisites);
        System.out.println(b);
        Assert.assertEquals(true, b);

        numCourses = 2;
        prerequisites = new int[][]{{1,0}, {0,1}};
        b = solution.canFinish(numCourses, prerequisites);
        System.out.println(b);
        Assert.assertEquals(false, b);
    }
}



