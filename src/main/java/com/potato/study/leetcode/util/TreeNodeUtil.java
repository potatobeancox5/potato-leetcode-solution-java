package com.potato.study.leetcode.util;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * TreeNode 工具类 树节点
 * @author Administrator
 *
 */
public class TreeNodeUtil {
	private TreeNodeUtil() {
		
	}

	
	/**
	 * 将字符串  转换成 类似代表二叉树结构的字符串：[5,1,4,null,null,3,6] 转换成树结构
	 * 输入字符转必须是二叉完成树表示方式
	 * 字符串形式不进行判断 字符串结构必须合法
	 * @param arrStr
	 * @return
	 */
	public static TreeNode generateTreeByArrayString(String arrStr) {
		if("[]".equals(arrStr)) {
			return null;
		}
		//去掉 【 和】
		String newArrStr = arrStr.substring(1, arrStr.length() - 1);
		// 分割字符串 
		String[] nodeValArr = newArrStr.split(",");
		// 生成的字符串数组对应一个满二叉树
		TreeNode head = generateTreeNode(0,nodeValArr);
		return head;
	}
	
	private static TreeNode generateTreeNode(int nodeIndex, String[] arr) {
		if(nodeIndex < arr.length) {
			if("null".equals(arr[nodeIndex])) {
				return null;
			} else {
				int val = Integer.parseInt(arr[nodeIndex]);
				TreeNode current = new TreeNode(val);
				current.left = generateTreeNode(2 * nodeIndex + 1, arr);
				current.right = generateTreeNode(2 * nodeIndex + 2, arr);
				return current;
			}
		}
		return null;
	}
	
	/**
	 * 打印给定二叉树  最后一层的null 指针舍去
	 * 打印结构类似： [2,1,4,null,null,3] 
	 * @param root			要打印的数根节点
	 * @param layerNum		树层数
	 */
	public static void printBSTTreeNodeInArrayString(TreeNode root, int layerNum) {
		//申请 字符串数组
		int nodeNum = (int) (Math.pow(2, layerNum) - 1);
		String[] nodeValues = new String[nodeNum]; 
		// 遍历BST 将节点值放到指定位置 默认index 0 放根节点
		preOrderTraversal(root, 0, nodeValues);
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("[");
		for (String nodeVal : nodeValues) {
			sBuilder.append(nodeVal).append(",");
		}
		if(sBuilder.length() > 1) {
			sBuilder.deleteCharAt(sBuilder.length() - 1);
		}
		sBuilder.append("]");
		System.out.println(sBuilder.toString());
	}
	
	/**
	 * 先序遍历节点 并将节点的值 放到数组的指定位置
	 * @param root
	 * @param nodeIndex
	 * @param nodeValues
	 */
	private static void preOrderTraversal(TreeNode root, int nodeIndex, String[] nodeValues) {
		if (nodeIndex >= nodeValues.length) {
			return;
		}
		nodeValues[nodeIndex] = root == null ? "null" : "" + root.val;
		if(root.left != null) {			
			preOrderTraversal(root.left, 2 * nodeIndex + 1, nodeValues);
		}
		if(root.right != null) {			
			preOrderTraversal(root.right, 2 * nodeIndex + 2, nodeValues);
		}
	}
	
	
	public static void main(String[] args) {
//		String arrStr = "[5,1,4,null,null,3,6]";
		String arrStr = "[]";
		TreeNode head = generateTreeByArrayString( arrStr);
		//测试输出
		printBSTTreeNodeInArrayString(head, 0);
	}
}
