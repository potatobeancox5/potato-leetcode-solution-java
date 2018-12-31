package com.potato.study.leetcode.p0095;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 	
 * 		95. Unique Binary Search Trees II
 * 		Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 *	For example,
 *	Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 *        
 * 
 *
 *         思路：
 *         题意： 给出了n 代表序列 1,2,3.。。。n
 *        		给出中序遍历序列是 1-n的 子树的种类
 */
public class Solution {
	
	public List<TreeNode> generateTrees(int n) {
		@SuppressWarnings("unchecked")
		List<TreeNode>[][] tmpResult = new ArrayList[n+1][n+1];
		if(n > 1) {
			return generateUniqueBst(1, n, tmpResult);
		} else if(n == 1){
			List<TreeNode> tree = new ArrayList<>();
			tree.add(new TreeNode(1));
			return tree;
		} else {
			return new ArrayList<>();
		}
    }

	
	
	private List<TreeNode> generateUniqueBst(int min, int max, List<TreeNode>[][] tmpResult) {
		if(tmpResult[min][max] != null) {
			return tmpResult[min][max];
		}
		List<TreeNode> trees = new ArrayList<>();
		if(min == max) {
			trees.add(new TreeNode(min));
			return trees;
		} else if (min > max) {
			return trees;
		} else {
			for(int i = min ; i <= max ; i++) {
//				TreeNode head = new TreeNode(i);
				if(min <= i-1 && i + 1 <= max) {
					List<TreeNode> leftLeaves = generateUniqueBst(min, i - 1, tmpResult);
					List<TreeNode> rightLeaves = generateUniqueBst(i + 1, max, tmpResult);
					// 拼接出新树，放在结果中
					for (Iterator<TreeNode> leftIterator = leftLeaves.iterator(); leftIterator.hasNext();) {
						TreeNode leftNode = leftIterator.next();
						for (Iterator<TreeNode> rightIterator = rightLeaves.iterator(); rightIterator.hasNext();) {
							TreeNode rightNode = rightIterator.next();
							TreeNode newHead = new TreeNode(i);
							newHead.left = leftNode;
							newHead.right = rightNode;
							trees.add(newHead);
						}
					}
				} else if(min > i - 1) { // 只有右边
					List<TreeNode> rightLeaves = generateUniqueBst(i + 1, max, tmpResult);
					for (TreeNode treeNode : rightLeaves) {
						TreeNode newHead = new TreeNode(i);
						newHead.right = treeNode;
						trees.add(newHead);
					}
				} else { //  i + 1 > max 只有左边
					List<TreeNode> leftLeaves = generateUniqueBst(min, i - 1, tmpResult);
					for (TreeNode treeNode : leftLeaves) {
						TreeNode newHead = new TreeNode(i);
						newHead.left = treeNode;
						trees.add(newHead);
					}
				}
			}
			tmpResult[min][max] = trees;
			return trees;
		}
	}

	public static void main(String[] args) {
//		Solution solution = new Solution();
	}
}
