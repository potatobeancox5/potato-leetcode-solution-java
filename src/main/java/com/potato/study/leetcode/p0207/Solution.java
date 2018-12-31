package com.potato.study.leetcode.p0207;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         207. Course Schedule
 * 
 * 			There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should
also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.


    题目需求：
        判断给定的课程序列是否能够正常完成
        拓扑排序
        1.遍历一般记录每个节点的入度
        2.选择入读为0的节点 修改其他节点的入度数值
    思路：
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> finishList = new ArrayList<>();
        Map<Integer, Course> courseMap = initCourse(numCourses, prerequisites);
        Set<Integer> canStartCourse = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!courseMap.containsKey(i)) {
                canStartCourse.add(i);
            } else if (courseMap.get(i).ingreeNum == 0) {
                canStartCourse.add(i);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(canStartCourse);
        // 从取出一个值，然后改变之前的入度，入度为0 入队
        while (!queue.isEmpty()) {
            Integer courseKey = queue.remove();
            finishList.add(courseKey);
            if (courseMap.containsKey(courseKey)) {
                Course course = courseMap.get(courseKey);
                if (course.prerequisiteList != null && course.prerequisiteList.size() > 0) {
                    for (int[] prerequisite : course.prerequisiteList) { // 修改入读 入读为0入队
                        Course target = courseMap.get(prerequisite[1]);
                        target.ingreeNum--;
                        if(target.ingreeNum == 0) {
                            queue.add(target.numCourse);
                        }
                    }
                }
            }
        }
        // 最后判断是否map中已经没有东西了 如果还有的还 那么说明有环
        if (finishList.size() == numCourses) {
            return true;
        }
        return false;
    }

    /**
     * 初始化课程列表
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private Map<Integer, Course> initCourse(int numCourses, int[][] prerequisites) {
        Map<Integer, Course> courseMap = new HashMap();
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            int after = prerequisite[1];
            if (courseMap.containsKey(pre)) {
                Course course = courseMap.get(pre);
                course.prerequisiteList.add(prerequisite);
                courseMap.put(pre, course);
            } else { // 创建 插入关系
                Course course = new Course();
                course.numCourse = pre;
                course.prerequisiteList.add(prerequisite);
                courseMap.put(pre, course);
            }
            if (courseMap.containsKey(after)) {
                Course course = courseMap.get(after);
                course.ingreeNum += 1;
                courseMap.put(after, course);
            } else { // 创建 增加入度
                Course course = new Course();
                course.numCourse = after;
                course.ingreeNum = 1;
                courseMap.put(after, course);
            }
        }
        return courseMap;
    }




	class Course {
        public int numCourse; // 课程编号（课程名）
        public int ingreeNum; // 前置课程数量
        public List<int[]> prerequisiteList = new ArrayList<>(); // 下一个课程列表
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
//        int[][] prerequisites = {{1,0}};
        int[][] prerequisites = {{1,0}, {0,1}};
        boolean canFinish = solution.canFinish(numCourses, prerequisites);
        System.out.println(canFinish);

    }
}
