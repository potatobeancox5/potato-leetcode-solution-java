package com.potato.study.leetcode.p0429;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 *   429. N-ary Tree Level Order Traversal
 * 
 *   Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:







We should return its level order traversal:

[
[1],
[3,2,4],
[5,6]
]


Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.

 * 			
 *     思路：
 *      队列 记录当前层信息
 *     
 * 			
 * 	
 */	
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> levelOrderList = new ArrayList<>();

        if (null == root) {
            return levelOrderList;
        }

        Queue<Node> nextNodeQueue = new LinkedList<>();
        nextNodeQueue.add(root);

        int currentLevelNum = 1; // 当前层总数量
        int currentNodeIndex = 0; // 目前遍历了多少个节点了 这个层的
        int nextLevelNum = 0; // 下一层有多少个节点
        List<Integer> currentLevelOrder = new ArrayList<>();

        while (!nextNodeQueue.isEmpty()) {
            Node node = nextNodeQueue.remove();
            currentNodeIndex++;
            currentLevelOrder.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                for (Node child : node.children) {
                    nextNodeQueue.add(child);
                    nextLevelNum++;
                }
            }
            // 判断当前是否是最后一个节点
            if (currentNodeIndex == currentLevelNum) {
                // 插入当前层数据 到一个结果
                levelOrderList.add(currentLevelOrder);
                currentLevelOrder = new ArrayList<>();
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                currentNodeIndex = 0;
            }
        }
        return levelOrderList;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
