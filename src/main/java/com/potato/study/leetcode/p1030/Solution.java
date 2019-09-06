package com.potato.study.leetcode.p1030;


import com.potato.study.leetcode.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1030. Matrix Cells in Distance Order
 *  
 *        We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.

Additionally, we are given a cell in that matrix with coordinates (r0, c0).

Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)



Example 1:

Input: R = 1, C = 2, r0 = 0, c0 = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (r0, c0) to other cells are: [0,1]
Example 2:

Input: R = 2, C = 2, r0 = 0, c0 = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
Example 3:

Input: R = 2, C = 3, r0 = 1, c0 = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].


Note:

1 <= R <= 100
1 <= C <= 100
0 <= r0 < R
0 <= c0 < C

 *         
 *         思路：
 *          创建一个对象 记录距离target的位置信息 ,然后对距离进行排序 升序 最终转换成，数组
 *
 *
 *
 */
public class Solution {

    class Distance {
        //row
        public int x;
        //colomn
        public int y;
        public int dis;
    }

    public int[][] allCellsDistOrder(int r, int c, int r0, int c0) {

        List<Distance> distanceList = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Distance distance = new Distance();
                distance.x = i;
                distance.y = j;
                distance.dis = Math.abs(i - r0) + Math.abs(j - c0);
                distanceList.add(distance);
            }
        }

        Collections.sort(distanceList, new Comparator<Distance>() {
            @Override
            public int compare(Distance o1, Distance o2) {
                return o1.dis - o2.dis;
            }
        });
        int[][] res = new int[distanceList.size()][2];
        for (int i = 0; i < distanceList.size(); i++) {
            res[i][0] = distanceList.get(i).x;
            res[i][1] =distanceList.get(i).y;
        }
        return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int r = 2;
        int c = 3;
        int r0 = 1;
        int c0 = 2;
        int[][] ints = solution.allCellsDistOrder(r, c, r0, c0);
        ArrayUtil.printMatrix(ints);
//        TreeNode root = solution.allCellsDistOrder(str);
//        TreePrintUtil.pirnt(root);
    }
}
