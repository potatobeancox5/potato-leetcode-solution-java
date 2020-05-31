package com.potato.study.leetcode.p1042;


import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1042. Flower Planting With No Adjacent
 *  
 *        You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

Also, there is no garden that has more than 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.



Example 1:

Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]
Example 2:

Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]
Example 3:

Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]


Note:

1 <= N <= 10000
0 <= paths.size <= 20000
No garden has 4 or more paths coming into or leaving it.
It is guaranteed an answer exists.
 *         
 *
 *         题目含义：
 *
 *          https://leetcode-cn.com/problems/flower-planting-with-no-adjacent/solution/bao-li-sou-suo-li-yong-setjian-hua-dai-ma-by-deips/
 *
 */
public class Solution {

    public int[] gardenNoAdj(int num, int[][] paths) {
        // 构造图结构
        int[] array = new int[num];
        byte[][] map = new byte[num][num];
        for (int p[] : paths) {
            map[p[0] - 1][p[1] - 1] = -1;
            map[p[1] - 1][p[0] - 1] = -1;
        }
        //A处：将相邻且上过色的节点保存
        //B处：利用set快速找出可选择的颜色，进行上色
        Set<Integer> set = new HashSet<>(4);
        for (int i = 0; i < num; ++i) {
            if (array[i] > 0) {
                continue;
            }
            set.clear();
            for (int j = 0; j < num; ++j) {
                if (map[i][j] != -1) {
                    continue;
                }
                if (array[j] == 0) {
                    continue;
                }
                set.add(array[j]);//A
            }
            for (int j = 1; j < 5; j++) {
                if (set.contains(j)) {
                    continue; //B
                }
                array[i] = j;
                break;
            }

        }
        return array;
    }

}
