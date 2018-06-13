package com.potato.study.leetcode.p0126;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.potato.study.leetcode.util.ListUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         126. Word Ladder II
 *         
 *    Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *         
 *         思路：
 *        	  BFS构建一个结果集的树（反向）
 *            dfs 反向遍历结果集 每次遇到 一组何时的值就在增加一个结果记录
 *            https://blog.csdn.net/tingting256/article/details/50365384?locationNum=16
 *            画个图就可以看清楚整个思路了
 *        	  
 *         
 *         
 * 
 */
public class Solution {
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 构建一组反向结果集 key 是单词 value 是 该单词对应的上一个单词的集合
		Map<String, Set<String>> endToBeginMap = generateResultMapByBFS(beginWord, endWord, wordList);
		// 从构建的结果中查找最终的结果 使用dfs
		List<List<String>> finalResult = new ArrayList<>();
		List<String> currentPath = new ArrayList<>();
		currentPath.add(endWord);
		findPathInMapByDFS(finalResult, endToBeginMap, beginWord, endWord, currentPath);
		return finalResult;
    }
	
	/**
	 * 从构建的结果中查找最终的结果 使用dfs
	 * @param finalResult
	 * @param endToBeginMap		之前构造的结果集
	 * @param beginWord			开始的单词	
	 * @param endWord			结束的单词
	 * @param currentPath		之前遍历了那些节点 本次遍历的节点放在之前遍历的节点之后 最后找到 开始单词的时候 在进行反转就可以了
	 */
	private void findPathInMapByDFS(List<List<String>> finalResult, Map<String, Set<String>> endToBeginMap, 
			String beginWord, String endWord, List<String> currentPath) {
		if(endWord.equals(beginWord)) {
			List<String> result = new ArrayList<>(currentPath);
//			result.add(beginWord);
			Collections.reverse(result);
			finalResult.add(result);
			return;
		} else { // 递归进行查找下一个但系
			Set<String> nextRound = endToBeginMap.get(endWord);
			if(null == nextRound || nextRound.size() == 0) {
				return;
			}
			for (String word : nextRound) {
				List<String> newCurrentPath = new ArrayList<>(currentPath);
				newCurrentPath.add(word);
				// 递归查找下一个节点
				findPathInMapByDFS(finalResult, endToBeginMap, beginWord, word, newCurrentPath);
			}
		}
	}
	
	/**
	 * 使用bfs生成 反向对应结果集
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	private Map<String, Set<String>> generateResultMapByBFS(String beginWord, String endWord, List<String> wordList) {
		Map<String, Set<String>> endToBeginMap = new HashMap<>();
		// 存储当前层要访问的节点set
		Set<String> currentVisit = new HashSet<>();
		currentVisit.add(beginWord);
		// 存储当前还可以访问的节点set(没有被访问多的节点)
		Set<String> notYetVisit = new HashSet<>(wordList);
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
							// 创建对应关系map
							boolean existed = endToBeginMap.containsKey(tmp);
							if(existed) {
								Set<String> tmpSet = endToBeginMap.get(tmp);
								tmpSet.add(currentWord);
							} else {
								Set<String> tmpSet = new HashSet<>();
								tmpSet.add(currentWord);
								endToBeginMap.put(tmp, tmpSet);
							}
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
			// 判断标志符号 若为true 那么跳出循环 
			if(canStop) {
				break;
			}
			//遍历完当前层节点之后 将下一层节点从没有访问的set中删掉 并重置当前需要访问节点
			notYetVisit.removeAll(nextLayerVisit);
			currentVisit = nextLayerVisit;
		}
		return endToBeginMap;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String beginWord = "hit";
		String endWord = "cog";
		String string = "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]";
		List<String> wordList = ListUtil.stringToList(string);
		List<List<String>> result = solution.findLadders(beginWord, endWord, wordList);
		ListUtil.printListList(result);
	}
}
