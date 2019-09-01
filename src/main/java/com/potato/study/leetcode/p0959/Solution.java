package com.potato.study.leetcode.p0959;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	959. Regions Cut By Slashes
 *  
 *       In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.

(Note that backslash characters are escaped, so a \ is represented as "\\".)

Return the number of regions.



Example 1:

Input:
[
" /",
"/ "
]
Output: 2
Explanation: The 2x2 grid is as follows:

Example 2:

Input:
[
" /",
"  "
]
Output: 1
Explanation: The 2x2 grid is as follows:

Example 3:

Input:
[
"\\/",
"/\\"
]
Output: 4
Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
The 2x2 grid is as follows:

Example 4:

Input:
[
"/\\",
"\\/"
]
Output: 5
Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
The 2x2 grid is as follows:

Example 5:

Input:
[
"//",
"/ "
]
Output: 3
Explanation: The 2x2 grid is as follows:



Note:

1 <= grid.length == grid[0].length <= 30
grid[i][j] is either '/', '\', or ' '.
 *         
 *         题目含义：
 *
 *         思路：
 *          数据结构并查集
 *              https://blog.csdn.net/niushuai666/article/details/6662911
 *          什么是并查集
 *              给定一个数组记录每一个节点的前驱是谁
 *          通过这个数组能够找到相同的前驱证明两个节点是否连通
 *          并查集
 *          https://segmentfault.com/a/1190000017571421?utm_source=tag-newest
 *
 *
 *
 *
 * 
 */
public class Solution {
    public int regionsBySlashes(String[] grid) {
        // 将一个方格 按照对角线划分为4个区域 每个区域是一个并查集单元
        List<DisJointSet> disJointSetList = new ArrayList<>();
        for (String line : grid) {
            for (char colom : line.toCharArray()) {
                disJointSetList.add(new DisJointSet());
                disJointSetList.add(new DisJointSet());
                disJointSetList.add(new DisJointSet());
                disJointSetList.add(new DisJointSet());
            }
        }
        // 按照 grid 字符进行单元组合 ，并将相邻的单元进行关联
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char column = grid[i].charAt(j);
                DisJointSet d1 = disJointSetList.get(index++);
                DisJointSet d2 = disJointSetList.get(index++);
                DisJointSet d3 = disJointSetList.get(index++);
                DisJointSet d4 = disJointSetList.get(index++);
                if (' ' == column) {
                    DisJointSet.union(d1, d2);
                    DisJointSet.union(d2, d3);
                    DisJointSet.union(d3, d4);
                } else if ('/' == column) {
                    DisJointSet.union(d1, d4);
                    DisJointSet.union(d2, d3);
                } else if ('\\' == column) {
                    DisJointSet.union(d1, d2);
                    DisJointSet.union(d3, d4);
                }
                // 自然相邻
                if (i < grid.length - 1) {
                    DisJointSet.union(d3, disJointSetList.get(index - 1 + 4 * grid[i].length() - 2 - 1));
                }
                if (j < grid[i].length() - 1) {
                    DisJointSet.union(d2, disJointSetList.get(index + 4 - 1));
                }
            }
        }
        // 遍历最终单元，找到有多少个不想链接首元素
        int count = 0;
        for (DisJointSet disJointSet : disJointSetList) {
            if (disJointSet == disJointSet.findRoot()) {
                count++;
            }
        }
        return count;
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
//        String[] grid = {" /", "  "};
//        String[] grid = {" /", "/ "};
//        String[] grid = {"\\/", "/\\"};
//        String[] grid = {"/\\", "\\/"}; // 5
        String[] grid = {"//", "/ "}; // 3
        int num = solution.regionsBySlashes(grid);
        System.out.println(num);
    }
}


/**
 * 并查集
 * 特点 如果 root == this 说明这个节点是根节点
 */
class DisJointSet {
    /**
     * 记录当前节点上级
     */
    public DisJointSet root = this;
    /**
     * 找到当前节点的根
     * @return
     */
    public DisJointSet findRoot() {
        if (this.root == this) {
            return this;
        } else {
            return this.root.findRoot();
        }
    }


    /**
     * 连接两个并查集合,没有进行路径优化
     * @param djs1
     * @param djs2
     */
    public static void union(DisJointSet djs1, DisJointSet djs2) {
        DisJointSet root1 = djs1.findRoot();
        DisJointSet root2 = djs2.findRoot();
        if (root1 != root2) {
            root2.root = root1;
        }
    }
}