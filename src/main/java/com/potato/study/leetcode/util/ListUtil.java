package com.potato.study.leetcode.util;

import java.util.ArrayList;
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
	public static <T> void printListList(List<List<T>> list) {
		int outerLength = list.size();
		System.out.println("{");
		for(int i = 0 ; i < outerLength ; i++) {
			List<T> innerList = list.get(i);
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
	
	public static <T> void printList(List<T> list) {
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
	
	/**
	 * 数字或者字符串转成list
	 * @param string		字符串 like ["hot","dot","dog","lot","log"]
	 * @return				转成的list
	 */
	public static List<String> stringToList(String string) {
		List<String> list = new ArrayList<>();
		if(null == string || string.length() < 2) {
			return list;
		}
		// 去掉两边得括号
		String newStr = string.substring(1, string.length() - 1);
		// 判断去掉之后 还有没有东西了
		if(newStr.length() == 0) {
			return list;
		}
		// 使用 ， 进行分割
		String[] oriStrs = newStr.split(",");
		//  去掉引号  注意去掉引号为“” 的情况
		for (String word : oriStrs) {
			list.add(word.substring(1, word.length() - 1));
		}
		// 将处理好的字符串 放到list中
		return list;
	}
	
	public static void main(String[] args) {
		String string = "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]";
		List<String> list = stringToList(string);
		System.out.println(list);
	}
}
