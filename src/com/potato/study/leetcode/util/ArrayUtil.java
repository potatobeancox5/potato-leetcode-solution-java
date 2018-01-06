package com.potato.study.leetcode.util;

import java.util.List;

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
	
	/**
	 * 打印两层list
	 * @param list
	 * @return
	 */
	public static void printListList(List<List<Integer>> list) {
		int outerLength = list.size();
		System.out.println("{");
		for(int i = 0 ; i < outerLength ; i++) {
			List<Integer> innerList = list.get(i);
			System.out.print("[");
			StringBuilder sBuilder = new StringBuilder();
			for(int j = 0 ; j < innerList.size() ; j++) {
				sBuilder.append(innerList.get(j)).append(",");
			}
			sBuilder.deleteCharAt(sBuilder.length() - 1);
			System.out.print(sBuilder.toString());
			System.out.println("]");
		}
		System.out.println("}");
	}
}
