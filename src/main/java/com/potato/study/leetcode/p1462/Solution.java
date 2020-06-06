package com.potato.study.leetcode.p1462;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1462. Course Schedule IV
 *  
 *
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have direct prerequisites, for example, to take course 0 you have first to take course 1, which is expressed as a pair: [1,0]

Given the total number of courses n, a list of direct prerequisite pairs and a list of queries pairs.

You should answer for each queries[i] whether the course queries[i][0] is a prerequisite of the course queries[i][1] or not.

Return a list of boolean, the answers to the given queries.

Please note that if course a is a prerequisite of course b and course b is a prerequisite of course c, then, course a is a prerequisite of course c.



Example 1:


Input: n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: course 0 is not a prerequisite of course 1 but the opposite is true.
Example 2:

Input: n = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation: There are no prerequisites and each course is independent.
Example 3:


Input: n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]
Example 4:

Input: n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
Output: [false,true]
Example 5:

Input: n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
Output: [true,false,true,false]


Constraints:

2 <= n <= 100
0 <= prerequisite.length <= (n * (n - 1) / 2)
0 <= prerequisite[i][0], prerequisite[i][1] < n
prerequisite[i][0] != prerequisite[i][1]
The prerequisites graph has no cycles.
The prerequisites graph has no repeated edges.
1 <= queries.length <= 10^4
queries[i][0] != queries[i][1]
 *
 *
 *
 * 思路：
 *
 * https://leetcode-cn.com/problems/course-schedule-iv/solution/ru-guo-bu-hui-floydye-ke-yi-yong-bfslai-shi-xian-b/
 *
 */
public class Solution {


    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        //构建一个可达的map表，留着一会bfs用
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] val : prerequisites) {
            HashSet<Integer> set = map.containsKey(val[0]) ? map.get(val[0]) : new HashSet<>();
            set.add(val[1]);
            map.put(val[0], set);
        }

        //创建一个结果集，里面存放所有可达关系
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            bfser(map, i, n, res);
        }

        //统计答案
        List<Boolean> ans = new ArrayList<>();
        for (int[] val : queries) {
            ans.add(res.contains(val[0] + "_" + val[1]));
        }
        return ans;
    }

    private void bfser(HashMap<Integer, HashSet<Integer>> map, int i, int n, HashSet<String> res) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        //如果这个值在map中不存在，说明他到其他课程没有可达关系
        if (!map.containsKey(i)) {
            return;
        }
        queue.offerLast(i);
        //我们的目标就是求root到其他点的可达关系，所以在bfs过程中，记录下这个可达关系，放在set里，这里
        //我用 a_b 这种字符串形式来记录了。
        visited[i] = true;
        while (!queue.isEmpty()) {
            HashSet<Integer> data = map.get(queue.pollFirst());
            if (data != null) {
                for (Integer d : data) {
                    if (!visited[d]) {
                        res.add(i + "_" + d);
                        queue.offerLast(d);
                        visited[d] = true;
                    }
                }
            }
        }
        //遍历结束后，所有可达的线都可以记录下来，求完所有的课程即可形成一个最终的统计集合，就可以遍历一遍查询数据
        //来返回结果了。
    }

}
