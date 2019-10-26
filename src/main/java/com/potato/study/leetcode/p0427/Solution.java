package com.potato.study.leetcode.p0427;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         427. Construct Quad Tree
 * 
 *        We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.

Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.

Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:

Given the 8 x 8 grid below, we want to construct the corresponding quad tree:



It can be divided according to the definition above:





The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.

For the non-leaf nodes, val can be arbitrary, so it is represented as *.



Note:

N is less than 1000 and guaranteened to be a power of 2.
If you want to know more about the quad tree, you can refer to its wiki.

        思路：

https://blog.csdn.net/mikuluna/article/details/88697501

        递归生成4叉树
        1. 获取首点的值，如果遍历到其中所有点都一样 那么直接生成节点，
        2. 有一个点不一样 返回 new 节点 并递归生成 上下左右四个点
 * 
 */
public class Solution {

    public Node construct(int[][] grid) {
        return getFourTree(grid, 0, grid[0].length, 0, grid.length);
    }

    private Node getFourTree(int[][] grid, int left, int right, int up, int down) {
        int key = grid[up][left];
        for (int i = left; i < right; i++) {
            for (int j = up; j < down; j++) {
                if (key != grid[j][i]) {
                    Node leftUpChild = getFourTree(grid, left, (left + right) / 2, up, (up + down)/2);
                    Node rightUpChild = getFourTree(grid, (left + right) / 2, right, up, (up + down)/2);
                    Node leftDownChild = getFourTree(grid, left, (left + right) / 2, (up + down)/2, down);
                    Node rightDownChild = getFourTree(grid, (left + right) / 2, right, (up + down)/2, down);
                    return new Node(false, false, leftUpChild, rightUpChild, leftDownChild, rightDownChild);
                }
            }
        }
        // 都相同
        boolean val = (key == 1? true : false);
        return new Node(val, true, null, null, null, null);
    }
	
	
	public static void main(String[] args) {
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean val,boolean isLeaf,Node topLeft,Node topRight,Node bottomLeft,Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
