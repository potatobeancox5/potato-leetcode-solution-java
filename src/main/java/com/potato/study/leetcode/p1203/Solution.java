package com.potato.study.leetcode.p1203;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1203. Sort Items by Groups Respecting Dependencies
 *  
 *
There are n items each belonging to zero or one of m groups where group[i] is the group that the i-th item belongs to and it's equal to -1 if the i-th item belongs to no group. The items and the groups are zero indexed. A group can have no item belonging to it.

Return a sorted list of the items such that:

The items that belong to the same group are next to each other in the sorted list.
There are some relations between these items where beforeItems[i] is a list containing all the items that should come before the i-th item in the sorted array (to the left of the i-th item).
Return any solution if there is more than one solution and return an empty list if there is no solution.



Example 1:



Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
Output: [6,3,4,1,5,2,0,7]
Example 2:

Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
Output: []
Explanation: This is the same as example 1 except that 4 needs to be before 6 in the sorted list.


Constraints:

1 <= m <= n <= 3*10^4
group.length == beforeItems.length == n
-1 <= group[i] <= m-1
0 <= beforeItems[i].length <= n-1
0 <= beforeItems[i][j] <= n-1
i != beforeItems[i][j]
beforeItems[i] does not contain duplicates elements.
 *         
 *         思路：
 *https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies/solution/shuang-ceng-tuo-bu-pai-xu-by-apitar/
 *
 */
public class Solution {

    /* 基类，用于拓扑排序 */
    private static class Sortable {
        public int ID;
        public Set<Sortable> next;

        public Sortable(int ID) {
            this.ID = ID;
            this.next = new HashSet<>(); // 后继节点
        }
    }

    /* 项目类 */
    private static class Item extends Sortable {

        public Item(int ID) {
            super(ID);
        }
    }

    /* 项目组类 */
    private static class Group extends Sortable {
        public Map<Integer, Item> items = new HashMap<>();              // 项目组负责的项目
        public Map<Integer, Integer> itemInDegrees = new HashMap<>();   // 各项目节点的入度

        public Group(int ID) {
            super(ID);
        }
    }

    /* 拓扑排序结果类 */
    private static class SortResult {
        public boolean success;
        public List<Sortable> result;

        public SortResult(boolean success, List<Sortable> result) {
            this.success = success;
            this.result = result;
        }
    }

    private Map<Integer, Group> groups = new HashMap<>();           // 以项目组为节点构成的图
    private Map<Integer, Integer> groupInDegrees = new HashMap<>(); // 项目组节点的入度，方便拓扑排序

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        initialize(n, m, group, beforeItems);
        SortResult sortedGroups = topologicalSort(groups, groupInDegrees);  // 首先进行项目组的拓扑排序
        if (!sortedGroups.success) return new int[0];
        int[] ans = new int[n];
        int curr = 0;
        for (Sortable s1 : sortedGroups.result) {                           // 再对每组中的项目进行拓扑排序
            Group g = (Group) s1;
            SortResult sortedItems = topologicalSort(g.items, g.itemInDegrees);
            if (!sortedItems.success) return new int[0];
            for (Sortable s2 : sortedItems.result) {
                Item item = (Item) s2;
                ans[curr++] = item.ID;
            }
        }
        return ans;
    }

    /**
     * 拓扑排序代码
     * @param graph     待排序的图
     * @param inDegrees 图中各节点的入度
     * @return          排序结果
     */
    private SortResult topologicalSort(Map<Integer, ? extends Sortable> graph, Map<Integer, Integer> inDegrees) {
        List<Sortable> list = new ArrayList<>();
        Queue<Sortable> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet())  {
            if (entry.getValue() == 0)
                queue.offer(graph.get(entry.getKey()));
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Sortable sortable = queue.poll();
                for (Sortable s : sortable.next) {
                    int inDegree = inDegrees.get(s.ID);
                    if (inDegree == 1) queue.offer(s);
                    inDegrees.put(s.ID, inDegree - 1);
                }
                list.add(sortable);
            }
        }
        boolean success = list.size() == graph.size();
        return new SortResult(success, list);
    }

    /* 成员变量的预处理 */
    private void initialize(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int t = 0;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(i);
            if (group[i] == -1)
                group[i] = (m + t++);

        }
        for (int i = 0; i < m + t; i++) {
            groups.put(i, new Group(i));
            groupInDegrees.put(i, 0);
        }
        for (int i = 0; i < n; i++) {
            Group currentGroup = groups.get(group[i]);
            currentGroup.items.put(i, items[i]);
            currentGroup.itemInDegrees.put(i, 0);
        }
        for (int i = 0; i < n; i++) {
            Group currentGroup = groups.get(group[i]);
            for (int j : beforeItems.get(i)) {
                if (group[i] == group[j]) {
                    items[j].next.add(items[i]);
                    currentGroup.itemInDegrees.compute(i, (k, v) -> v + 1);
                } else {
                    groups.get(group[j]).next.add(currentGroup);
                }
            }
        }
        for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
            Group g = entry.getValue();
            for (Sortable next : g.next) {
                groupInDegrees.compute(next.ID, (k, v) -> v + 1);
            }
        }
    }
}
