package com.potato.study.leetcode.p0103;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         103. Binary Tree Zigzag Level Order Traversal
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 *
 *         思路： 正常测序遍历的同时 记录当前行有多少个元素 以及 下一行的元素数 以及 当前输出的行数
 *         
 *         当行数为偶数的时候 最终插入结果是 将list 倒转
 *         
 */
public class Solution {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(null == root) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		int nextLayerNum = 0;
		int currentLayerNum = 1;
		int countNodeNum = 0;
		int layerNum = 1;
		queue.add(root);
		List<Integer> currentList = new ArrayList<>();
		while(!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			currentList.add(curNode.val);
			countNodeNum++;
			if(curNode.left != null) {
				queue.add(curNode.left);
				nextLayerNum++;
			} 
			if(curNode.right != null) {
				queue.add(curNode.right);
				nextLayerNum++;
			}
			if(countNodeNum == currentLayerNum) { // 到达本层最后一个节点 
				currentLayerNum = nextLayerNum;
				nextLayerNum = 0;
				countNodeNum = 0;
				//若当前行是偶数行 需要对list进行倒置
				if(layerNum % 2 == 1) {
					result.add(new ArrayList<>(currentList));
				} else {
					result.add(reverse(currentList));
				}
				currentList.clear();
				layerNum++;
			}
		}
        return result;
    }
	
	/**
	 * 返回list 的倒置 镜像(原list保持布标)
	 * @param list
	 * @return
	 */
	private static <T> List<T> reverse(List<T> list) {
		if(list == null) {
			return null;
		}
		List<T> newList = new ArrayList<>();
		for(int i = 0 ; i < list.size() ; i++ ) {
			newList.add(list.get(list.size() - i - 1));
		}
		return newList;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String arrStr = "[3,9,20,null,null,15,7]";
		TreeNode root = TreeNodeUtil.generateTreeByArrayString(arrStr);
		List<List<Integer>> list = solution.zigzagLevelOrder(root);
		System.out.println(list);
	}
}
