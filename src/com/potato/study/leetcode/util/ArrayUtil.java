package com.potato.study.leetcode.util;

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
}
