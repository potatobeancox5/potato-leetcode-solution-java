package com.potato.study.leetcode.p0096;

/**
 * 
 * @author liuzhao11
 * 
 *         96. Unique Binary Search Trees Given n, how many structurally unique
 *         BST's (binary search trees) that store values 1...n?
 * 
 *         For example, Given n = 3, there are a total of 5 unique BST's.
 * 
 *         1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 *
 *         思路： 给定一个数n，求1到n这些数可以构成多少棵二叉树。
 *         给定一个序列1.....n，为了构造所有二叉树，我们可以使用1......n中的每一个数i作为根节点，自然1......(i-1)
 *         必然位于树的左子树中，(i+1).....n位于树的右子树中。然后可以递归来构建左右子树，由于根节点是唯一的，
 *         所以可以保证构建的二叉树都是唯一的。
 */
public class Solution {

	public int numTrees(int n) {
		int[][] tmpResult = new int[n+1][n+1];
		if(n > 1) {
			return countUniqueBst(1, n, tmpResult);
		} else {
			return 1;
		}
        
    }
	
	private int countUniqueBst(int min, int max, int[][] tmpResult) {
		if(tmpResult[min][max] != 0) { 
			return tmpResult[min][max];
		}
		if(min == max) {
			tmpResult[min][max] = 1;
			return 1;
		} else if(min > max){
			return 0;
		} else {
			int count = 0;
			for(int i = min ; i <= max ; i++) {
				if(min <= i-1 && i + 1 <= max) {					
					count += countUniqueBst(min, i - 1, tmpResult) * countUniqueBst(i + 1, max, tmpResult);
				} else if(min > i - 1) {
					count += countUniqueBst(i + 1, max, tmpResult);
				} else { //  i + 1 > max
					count += countUniqueBst(min, i - 1, tmpResult);
				}
			}
			tmpResult[min][max] = count;
			return count;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int count = solution.numTrees(19);
		System.out.println(count);
	}
}
