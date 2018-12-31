package com.potato.study.leetcode.p0406;

import com.potato.study.leetcode.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author liuzhao11
 * 
 *   406. Queue Reconstruction by Height
 * 
 *      Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 *   题目含义：
 *      给定一组pair数字 <身高，之前有多少人比这个人高>
 *      输出：建立这个队列
 *   思路：
 *   解法见下面blog
 *   https://www.cnblogs.com/grandyang/p/5928417.html
 *   y？
 *   原因：
 *   https://blog.csdn.net/wyh476901857/article/details/70495661
 *   步骤：
 *   1.先排序 按照身高降序，位置升序排列
 *   2.按照排序后的数组 每个元素的第二个数字作为index 插入 如果改位置有人了，那么 后移原先插入的数字
 *
 *
 */
public class Solution {


    public int[][] reconstructQueue(int[][] people) {
        if (null == people || people.length == 0
                || people[0] == null || people[0].length == 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                按照身高降序，位置升序排列
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int [][] peopleQueue = new int[people.length][2];
        for (int i = 0; i < people.length ; i++) {
            int index = people[i][1];
//            if (peopleQueue[index][0] == 0 && peopleQueue[index][1] == 0) {
            if (isBlank(peopleQueue, index)) {
                peopleQueue[index] = people[i];
            } else { // 后移
                // 找到和面的空档
                int blankIndex = index + 1;
                while (blankIndex < peopleQueue.length - 1 && !isBlank(peopleQueue, blankIndex)) {
                    blankIndex++;
                }
                for (int j = blankIndex; j > index && j < people.length; j--) {
                    peopleQueue[j] = peopleQueue[j - 1];
                }
                peopleQueue[index] = people[i];
            }
        }
        return peopleQueue;
    }

    private boolean isBlank(int[][] matrix, int x) {
        if (matrix[x][0] == 0 && matrix[x][1] == 0) {
            return true;
        }
        return false;
     }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		int [][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = solution.reconstructQueue(people);
        ArrayUtil.printMatrix(result);

    }
}
