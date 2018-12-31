package com.potato.study.leetcode.p0127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.potato.study.leetcode.util.ListUtil;

/**
 * 
 * @author liuzhao11
 * 
 *        127. Word Ladder
 *         
 *    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.*         
 *         思路：上一个题改的
 *        	 
 *        	  
 *         
 *         
 * 
 */
public class Solution {
	
	
	/**
	 * bfs
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int layer = 1;
		// 存储当前层要访问的节点set
		Set<String> currentVisit = new HashSet<>();
		currentVisit.add(beginWord);
		// 存储当前还可以访问的节点set(没有被访问多的节点)
		Set<String> notYetVisit = new HashSet<>(wordList);
		// 剪枝 判断 wordlist中 直接不存在endWord的情况
		if(!notYetVisit.contains(endWord)) {
			return 0;
		}
		// 设定标志符号 canStop = false
		boolean canStop = false;
		// 如果当前层还有节点可以访问 
		while(!currentVisit.isEmpty()) {
			// 存储当前层访问之后 访问那一层的节点set(下一层要访问的节点)
			Set<String> nextLayerVisit = new HashSet<>();
			// 遍历当前访问节点结合
			for (String currentWord : currentVisit) {				
				// 在还可以访问的节点结合中 寻找邻接节点 找到 放进下一层访问几点 并建立endToBeginMap 中的关系
				for(int i = 0 ; i < currentWord.length() ; i++) { 
					//控制当前改变那个字母 位置
					for(int j = 0 ; j < 26 ; j++) {
						// 计算改变成的字母
						char ch = (char) ('a' + j);
						char[] chArray = currentWord.toCharArray();
						chArray[i] = ch;
						String tmp = new String(chArray);
						// 判断是否是 邻接节点
						if(notYetVisit.contains(tmp)) {
							// 当前节点为下一层需要遍历的节点
							nextLayerVisit.add(tmp);
						} else {
							continue;
						}
						// 如果当前找到节点 标志符号 canStop = true
						if(endWord.equals(tmp)) {
							canStop = true;
						}
					}
				}
			}
			layer++;
			// 判断标志符号 若为true 那么跳出循环 
			if(canStop) {
				break;
			}
			//遍历完当前层节点之后 将下一层节点从没有访问的set中删掉 并重置当前需要访问节点
			notYetVisit.removeAll(nextLayerVisit);
			currentVisit = nextLayerVisit;
		}
		
		// 如果一直没有canStop 那么为0
		if(!canStop) {
			return 0;
		}
		return layer;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String beginWord = "hit";
		String endWord = "cog";
		String string = "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]";
		List<String> wordList = ListUtil.stringToList(string);
		int result = solution.ladderLength(beginWord, endWord, wordList);
		System.out.println(result);
	}
}
