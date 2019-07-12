package com.potato.study.leetcode.p0558;

import com.potato.study.leetcode.domain.Node;

/**
 * 
 * @author liuzhao11
 * 
 *         558. Quad Tree Intersection
 * 
 *         A quadtree is a tree data in which each internal node has exactly four children: topLeft, topRight, bottomLeft and bottomRight. Quad trees are often used to partition a two-dimensional space by recursively subdividing it into four quadrants or regions.

We want to store True/False information in our quad tree. The quad tree is used to represent a N * N boolean grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same. Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.

For example, below are two quad trees A and B:

A:
+-------+-------+   T: true
|       |       |   F: false
|   T   |   T   |
|       |       |
+-------+-------+
|       |       |
|   F   |   F   |
|       |       |
+-------+-------+
topLeft: T
topRight: T
bottomLeft: F
bottomRight: F

B:
+-------+---+---+
|       | F | F |
|   T   +---+---+
|       | T | T |
+-------+---+---+
|       |       |
|   T   |   F   |
|       |       |
+-------+-------+
topLeft: T
topRight:
topLeft: F
topRight: F
bottomLeft: T
bottomRight: T
bottomLeft: T
bottomRight: F


Your task is to implement a function that will take two quadtrees and return a quadtree that represents the logical OR (or union) of the two trees.

A:                 B:                 C (A or B):
+-------+-------+  +-------+---+---+  +-------+-------+
|       |       |  |       | F | F |  |       |       |
|   T   |   T   |  |   T   +---+---+  |   T   |   T   |
|       |       |  |       | T | T |  |       |       |
+-------+-------+  +-------+---+---+  +-------+-------+
|       |       |  |       |       |  |       |       |
|   F   |   F   |  |   T   |   F   |  |   T   |   F   |
|       |       |  |       |       |  |       |       |
+-------+-------+  +-------+-------+  +-------+-------+
Note:

Both A and B represent grids of size N * N.
N is guaranteed to be a power of 2.
If you want to know more about the quad tree, you can refer to its wiki.
The logic OR operation is defined as this: "A or B" is true if A is true, or if B is true, or if both A and B are true.
 * 
 * 
 *         思路：
 *         https://blog.csdn.net/lym940928/article/details/81263132
 *
 *         递归处理两个节点
 *          如果a是叶子节点
 *              a true 返回 a
 *              a false 返回 b
 *          同理 如果b是叶子节点 按照b进行返回
 *
 *          如果 ab 都不是叶子节点 递归进行返回
 *
 *
 *
 *       
 *          
 */
public class Solution {

    /**
     * 合并两个tree
     * @param quadTree1
     * @param quadTree2
     * @return
     */
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return quadTree1;
            } else {
                return quadTree2;
            }
        } else if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                return quadTree2;
            } else {
                return quadTree1;
            }
        } else { // 两个都不是叶子节点
            Node newRoot = new Node();
            // 获取子节点的结果
            Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            // 根据子节点结果决定该节点是否是叶子节点
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                    && topLeft.val == topRight.val && topRight.val == bottomLeft.val
                    && bottomLeft.val == bottomRight.val) {
                newRoot.val = topLeft.val;
                newRoot.isLeaf = true;
            } else {
                newRoot.isLeaf = false;
                newRoot.topLeft = topLeft;
                newRoot.topRight = topRight;
                newRoot.bottomLeft = bottomLeft;
                newRoot.bottomRight = bottomRight;
            }
            return newRoot;
        }
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        Node quadTree1 = null;
        Node quadTree2 = null;
        solution.intersect(quadTree1, quadTree2);

    }
}
