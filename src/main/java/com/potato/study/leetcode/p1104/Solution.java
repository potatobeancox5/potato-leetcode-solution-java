package com.potato.study.leetcode.p1104;


import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1104. Path In Zigzag Labelled Binary Tree
 *  
 *         In an infinite binary tree where every node has two children, the nodes are labelled in row order.

In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.



Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.



Example 1:

Input: label = 14
Output: [1,3,4,14]
Example 2:

Input: label = 26
Output: [1,2,6,10,26]


Constraints:

1 <= label <= 10^6
 *
 *
 *
 *   解题思路：
 *      按照正常顺序进行遍历，然后对于偶数节点，进行替换
 *
 *      https://blog.csdn.net/qq_24342739/article/details/94310615
 *
 */
public class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        // 首先确定 实际要找的数字的位置，如果是偶数层 需要进行互换
        List<Integer> path = new LinkedList<>();
        // 顺序找到路径 每个节点 奇数节点 父节点为 n -1 / 2 偶数节点 父节点 n / 2
        int index = label;
        // 因此进行反向确定父节点
        while (index > 0) {
            // 当前节点作为遍历节点
            path.add(0, index);
            // 找到父节点
            index /= 2;
        }
        // 判断真实目标
        int sum = (1 << (path.size() - 1)) + ((1 << path.size())- 1);
//        System.out.println(sum);
        index = (path.size() % 2 == 1 ? label : sum - label);
//        System.out.println(index);
        path = new LinkedList<>();
        while (index > 0) {
            // 当前节点作为遍历节点
            path.add(0, index);
            // 找到父节点
            index /= 2;
        }
//        System.out.println(path);
        // 节点转换 公式 计算当前层 sum = 2^i + 2^(i+1) - 1 - currentVal
        for (int i = 0; i < path.size(); i++) {
            if (i % 2 == 1) {
                // 第偶数层 需要进行转换
                sum = (1 << i) + ( (1 << (i + 1))- 1);
                int currentVal = path.get(i);
                path.set(i, sum - currentVal);
            } else {
                continue;
            }
        }
        return path;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
        int label = 14;
        List<Integer> res = solution.pathInZigZagTree(label);
        System.out.println(res);
    }
}
