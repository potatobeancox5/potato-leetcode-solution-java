package com.potato.study.leetcode.util;

import java.util.List;

/**
 * 处理list 的工具类
 * @author Administrator
 *
 */
public class ListUtil {

	private ListUtil() {
		
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
			if(innerList.size() > 0) { // 去掉最后一个 ， 				
				sBuilder.deleteCharAt(sBuilder.length() - 1);
			}
			System.out.print(sBuilder.toString());
			System.out.println("]");
		}
		System.out.println("}");
	}
	
	public static <T> void  printList(List<T> list) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("[");
		for (T t : list) {
			sBuilder.append(t.toString()).append(",");
		}
		if(list.size() > 0) { // 去掉最后一个 , 
			sBuilder.deleteCharAt(sBuilder.length() - 1);
		}
		sBuilder.append("]");
		System.out.println(sBuilder.toString());
	}
}
