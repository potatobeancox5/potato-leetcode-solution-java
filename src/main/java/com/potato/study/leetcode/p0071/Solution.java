package com.potato.study.leetcode.p0071;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *         71. Simplify Path
 * 
 *         Given an absolute path for a file (Unix-style), simplify it.

			For example,
			path = "/home/", => "/home"
			path = "/a/./b/../../c/", => "/c"
			
			Did you consider the case where path = "/../"?
	In this case, you should return "/".
	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
	In this case, you should ignore redundant slashes and return "/home/foo".

 *         思路：
 * 			遍历给定的字符串，使用StringBuilder存储当前待处理的文件夹名,令开一个stack存储目前的路径
 * 			如果当前位置字符不是‘/’，StringBuilder append 
 * 			如果当前位置是‘/‘
 * 				判断StringBuilder 是’‘ 是的话 证明是第一个位置或者连续’//‘，继续遍历
 * 				StringBuilder不为'' 
 * 					判断目录是否是.. 是的话  弹栈（不空时）
 * 					判断是否是'.' 是的话 清空	StringBuilder 继续遍历
 * 					不是上面的情况	则将StringBuilder 进栈 StringBuilder 清空
 * 			处理最后一个位置
 * 				判断目录是否是.. 是的话  弹栈（不空时）
 * 				判断是否是'.' 是的话  什么都不做
 * 				不是上面的情况	则将StringBuilder 进栈 
 * 
 * 			将栈按照由栈底到栈顶的顺序遍历输出fore
 * 					
 * 
 * 
 */
public class Solution {

	public String simplifyPath(String path) {
		if(null == path || path.length() == 0) {
			return "/";
		}
		// 遍历给定的字符串，使用StringBuilder存储当前待处理的文件夹名,令开一个stack存储目前的路径
		StringBuilder pathBuilder = new StringBuilder();// 暂时存放当前文件件名称
		Stack<String> folderPathStack = new Stack<>();// 存放当前目录栈
		for (int i = 0; i < path.length(); i++) {
			// 如果当前位置字符不是‘/’，StringBuilder append
			if (path.charAt(i) != '/') {
				pathBuilder.append(path.charAt(i));
			} else {
				// * 如果当前位置是‘/‘
				if (pathBuilder.length() == 0) {
					// * 判断StringBuilder 是’‘ 是的话 证明是第一个位置或者连续’//‘，继续遍历
					continue;
				} else {
					// * StringBuilder不为''
					if ("..".equals(pathBuilder.toString())) {
						// * 判断目录是否是.. 是的话 弹栈（不空时）
						if (!folderPathStack.isEmpty()) {
							folderPathStack.pop();
						}
					} else if (!".".equals(pathBuilder.toString())) {
						// * 判断是否是'.' 是的话 清空 StringBuilder 继续遍历
						folderPathStack.push(pathBuilder.toString());
					}
					// 清空暂时存储的文件夹名称，开始保存新的文件夹名称
					pathBuilder.delete(0, pathBuilder.length());

				}
			}
		}
		// * 处理最后一个位置
		if ("..".equals(pathBuilder.toString())) {
			// * 判断目录是否是.. 是的话 弹栈（不空时）
			if (!folderPathStack.isEmpty()) {
				folderPathStack.pop();
			}
		} else if (!".".equals(pathBuilder.toString()) && pathBuilder.length() > 0) {
			// * 判断是否是'.' 是的话 清空 StringBuilder 继续遍历
			folderPathStack.push(pathBuilder.toString());
		}
//			* 			将栈按照由栈底到栈顶的顺序遍历输出fore
		StringBuilder finalPath = new StringBuilder();
		for (String folderPath : folderPathStack) {
			finalPath.append("/").append(folderPath);
		}
		if(finalPath.length() == 0 ) {
			finalPath.append("/");
		}
		return finalPath.toString();
		
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String path = "/home//foo/";
		String simplePath = solution.simplifyPath(path);
		System.out.println(simplePath);
	}
}
