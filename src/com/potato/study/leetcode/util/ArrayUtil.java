package com.potato.study.leetcode.util;import java.util.Arrays;

/**
 * 数组工具类
 * @author Administrator
 *
 */
public class ArrayUtil {
	
	private ArrayUtil() {
		
	}
	
	public static boolean isBlank(int[] arr) {
		if(null == arr || arr.length == 0) {
			return true;
		}
		return false;
	}
	
	public static void printMatrix(int[][] matrix) {
		if(null == matrix || matrix.length == 0) {
			return ;
		}
		System.out.println("[");
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("]");
	}
	
	public static void printMatrix(char[][] matrix) {
		if(null == matrix || matrix.length == 0) {
			return ;
		}
		System.out.println("[");
		for (char[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("]");
	}
	
}
