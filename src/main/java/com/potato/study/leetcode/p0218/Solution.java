package com.potato.study.leetcode.p0218;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *      218. The Skyline Problem
 * 
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 *
 * 思路：
 *      https://blog.csdn.net/azs1478963/article/details/51812937
        线段树 红黑树
        https://blog.csdn.net/azs1478963/article/details/51812937
        一步一步理解线段树


        简单的理解
        https://www.jianshu.com/p/68d516132001

        1. 遍历节点 按照 《起点， -value》 《终点， value》的形式入队
        2. 按照 出现顺序进行排序 升序 然后按照 value 升序排序
        3. 遍历数组，如果是起点的话 将值 value 取正 入heap （大根堆）
                    如果是终点的话 将值 value 从堆中删去
                heap peek 插入到结果中


 */
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 1. 遍历节点 按照 《起点， -value》 《终点， value》的形式入队
        List<List<Integer>> list = new ArrayList<>();
        if (null == buildings || buildings.length == 0) {
            return list;
        }
        for (int i = 0; i < buildings.length; i++) {
            List<Integer> node1 = new ArrayList<>();
            node1.add(buildings[i][0]);
            node1.add(-buildings[i][2]);
            list.add(node1);
            List<Integer> node2 = new ArrayList<>();
            node2.add(buildings[i][1]);
            node2.add(buildings[i][2]);
            list.add(node2);
        }
        //  2. 按照 出现顺序进行排序 升序 然后按照 value 升序排序
        Collections.sort(list, (o1, o2) -> {
            if (o1.get(0) != o2.get(0)) {
                return o1.get(0) - o2.get(0);
            }
            // 开始坐标相等之后，按照高度升序
            return o1.get(1) - o2.get(1);
        });
        // 获取最终节点
        int lastIndex = list.get(list.size() - 1).get(0);
        //  3. 遍历数组，如果是起点的话 将值 value 取正 入heap （大根堆）
        List<List<Integer>> skyLine = new ArrayList<>();
        int preHeight = 0; // 记录 前一个点的高度 结果中的前一个点的高度
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        heap.offer(0);// 处理空指针
        for (List<Integer> node : list) {
            if (node.get(1) < 0) {
                heap.offer(-node.get(1));
            } else {
                heap.remove(node.get(1));
            }
            if (node.get(0) == lastIndex) {
                continue;
            }
            if (preHeight != heap.peek()) {
                // 出现了高度差 意味着可以增加结果了 只记录起点
                List<Integer> skyLinePoint = new ArrayList<>();
                skyLinePoint.add(node.get(0));
                skyLinePoint.add(heap.peek());
                skyLine.add(skyLinePoint);
                preHeight = heap.peek();
            }
        }
        // 处理最后一个节点
        List<Integer> skyLinePoint = new ArrayList<>();
        skyLinePoint.add(lastIndex);
        skyLinePoint.add(0);
        skyLine.add(skyLinePoint);
        return skyLine;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] buildings = {{1,10001,10000}, {2,10001,9999}, {3,10001,9998}};
        List<List<Integer>> skyline = solution.getSkyline(buildings);
        System.out.println(skyline);
    }
}
